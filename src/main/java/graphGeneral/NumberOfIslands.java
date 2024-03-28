package graphGeneral;

import java.util.LinkedList;

public class NumberOfIslands {

  private class ScanIslandsTask {

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

    public ScanIslandsTask(char[][] grid) {
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

    public int scanRecursive() {
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

    public int scanIterative() {
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

  public int numIslands(char[][] grid) {
    ScanIslandsTask s = new ScanIslandsTask(grid);
    return s.scanRecursive();
  }

  public int numIslandsRecursive(char[][] grid) {
    ScanIslandsTask s = new ScanIslandsTask(grid);
    return s.scanRecursive();
  }

  public int numIslandsIterative(char[][] grid) {
    ScanIslandsTask s = new ScanIslandsTask(grid);
    return s.scanIterative();
  }
}
