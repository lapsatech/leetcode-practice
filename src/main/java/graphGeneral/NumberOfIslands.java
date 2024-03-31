package graphGeneral;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

import utils.graph.SimpleGraph;
import utils.graph.SimpleGraphTraverse;

public class NumberOfIslands {

  public int numIslands(char[][] grid) {
    return numIslandsRecursive(grid);
  }

  private static class Scan {

    private final boolean[] visited;
    private final char[][] grid;
    private final int m;
    private final int n;

    private boolean visited(int x, int y) {
      return visited[y * m + x];
    }

    private boolean setVisited(int x, int y) {
      int idx = y * m + x;
      if (visited[idx]) {
        return false;
      }
      visited[idx] = true;
      return true;
    }

    private Scan(char[][] grid) {
      this.m = grid.length;
      if (m <= 0 || m > 300) {
        throw new IllegalArgumentException("1 <= m, n <= 300 constraint violation");
      }
      this.n = grid[0].length;
      if (n <= 0 || n > 300) {
        throw new IllegalArgumentException("1 <= m, n <= 300 constraint violation");
      }
      for (char[] row : grid) {
        if (row.length != n) {
          throw new IllegalArgumentException("m x n 2D grid constraint violation");
        }
      }
      this.grid = grid;
      this.visited = new boolean[m * n];
    }

    private void scanLand(int x, int y) {
      if (setVisited(x, y)) {
        if (grid[x][y] == '0') {
          return;
        }

        if (x + 1 < m) {
          scanLand(x + 1, y);
        }
        if (x > 0) {
          scanLand(x - 1, y);
        }
        if (y + 1 < n) {
          scanLand(x, y + 1);
        }
        if (y > 0) {
          scanLand(x, y - 1);
        }

      }
    }

    private int scanRecursive() {
      int num = 0;
      for (int x = 0; x < m; x++) {
        for (int y = 0; y < n; y++) {
          if (visited(x, y)) {
            continue;
          }
          if (grid[x][y] == '1') {
            num++;
            scanLand(x, y);
          }
        }
      }
      return num;
    }

    private int scanIterative() {
      LinkedList<int[]> xyq = new LinkedList<>();

      int num = 0;
      for (int x = 0; x < m; x++) {
        for (int y = 0; y < n; y++) {
          if (visited(x, y)) {
            continue;
          }
          if (grid[x][y] == '1') {
            num++;
            xyq.addLast(new int[] { x, y });
            while (!xyq.isEmpty()) {
              int[] xy = xyq.removeLast();
              if (setVisited(xy[0], xy[1])) {
                if (grid[xy[0]][xy[1]] == '0') {
                  continue;
                }

                if (xy[0] + 1 < m) {
                  xyq.add(new int[] { xy[0] + 1, xy[1] });
                }
                if (xy[0] > 0) {
                  xyq.add(new int[] { xy[0] - 1, xy[1] });
                }
                if (xy[1] + 1 < n) {
                  xyq.add(new int[] { xy[0], xy[1] + 1 });
                }
                if (xy[1] > 0) {
                  xyq.add(new int[] { xy[0], xy[1] - 1 });
                }
              }
            }
          }
        }
      }
      return num;
    }
  }

  int numIslandsRecursive(char[][] grid) {
    Scan s = new Scan(grid);
    return s.scanRecursive();
  }

  int numIslandsIterative(char[][] grid) {
    Scan s = new Scan(grid);
    return s.scanIterative();
  }

  int numIslandsSimpleGraph(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    SimpleGraph<Xy> graph = new IslandsGraph(m, n);
    IslandsVisited visited = new IslandsVisited(m, n);
    SimpleGraphTraverse traverse = SimpleGraphTraverse.bfs();

    int num = 0;
    for (int x = 0; x < m; x++) {
      for (int y = 0; y < n; y++) {
        if (visited.visited(x, y)) {
          continue;
        }
        if (grid[x][y] == '1') {
          num++;
          traverse.traverse(graph, new Xy(x, y), xy -> {
            if (!visited.visit(xy.x, xy.y)) {
              return false;
            }
            if (grid[xy.x][xy.y] == '0') {
              return false;
            }
            return true;
          });
        }
      }
    }
    return num;
  }

  static class IslandsVisited {

    private final boolean[] visited;
    private int m;

    IslandsVisited(int m, int n) {
      this.m = m;
      this.visited = new boolean[m * n];
    }

    boolean visited(int x, int y) {
      return visited[y * m + x];
    }

    boolean visit(int x, int y) {
      int idx = y * m + x;
      if (visited[idx]) {
        return false;
      }
      visited[idx] = true;
      return true;
    }

  }

  static class Xy {
    final int x, y;

    public Xy(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Xy other = (Xy) obj;
      return x == other.x && y == other.y;
    }
  }

  static class IslandsGraph implements SimpleGraph<Xy> {

    private final int m;
    private final int n;

    IslandsGraph(int m, int n) {
      this.m = m;
      this.n = n;
    }

    @Override
    public Collection<Xy> childs(Xy xy) {
      ArrayList<Xy> childs = new ArrayList<>(4);

      if (xy.x + 1 < m) {
        childs.add(new Xy(xy.x + 1, xy.y));
      }
      if (xy.x > 0) {
        childs.add(new Xy(xy.x - 1, xy.y));
      }
      if (xy.y + 1 < n) {
        childs.add(new Xy(xy.x, xy.y + 1));
      }
      if (xy.y > 0) {
        childs.add(new Xy(xy.x, xy.y - 1));
      }

      return childs;
    }

    @Override
    public boolean isTheSame(Xy xy1, Xy xy2) {
      return xy1.x == xy2.x && xy1.y == xy2.y;
    }

  }
}
