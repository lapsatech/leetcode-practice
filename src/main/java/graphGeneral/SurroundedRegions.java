package graphGeneral;

import java.util.LinkedList;

public class SurroundedRegions {

  static class Coord {
    final int x, y;

    Coord(int x, int y) {
      this.x = x;
      this.y = y;
    }

  }

  static class Region {

    final LinkedList<Coord> coords = new LinkedList<>();
    boolean surrounded = true;

    Region(boolean surrounded) {
      this.surrounded = surrounded;
    }

    void add(int x, int y) {
      this.coords.add(new Coord(x, y));
    }

  }

  static class Scan {

    final boolean[] visited;
    final char[][] board;
    final int m;
    final int n;

    boolean visited(int x, int y) {
      return visited[y * m + x];
    }

    boolean setVisited(int x, int y) {
      int idx = y * m + x;
      if (visited[idx]) {
        return false;
      }
      visited[idx] = true;
      return true;
    }

    Scan(char[][] grid) {
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
      this.board = grid;
      this.visited = new boolean[m * n];
    }

    void scanRegion(Region region, int x, int y) {
      if (setVisited(x, y)) {
        if (board[x][y] == 'X') {
          return;
        }

        region.add(x, y);
        if (x == 0 || x + 1 == m || y == 0 || y + 1 == n) {
          region.surrounded = false;
        }

        if (x + 1 < m) {
          scanRegion(region, x + 1, y);
        }
        if (x > 0) {
          scanRegion(region, x - 1, y);
        }
        if (y + 1 < n) {
          scanRegion(region, x, y + 1);
        }
        if (y > 0) {
          scanRegion(region, x, y - 1);
        }

      }
    }

    void scanRecursive() {
      for (int x = 0; x < m; x++) {
        for (int y = 0; y < n; y++) {
          if (visited(x, y)) {
            continue;
          }
          if (board[x][y] == 'O') {
            Region region = new Region(true);
            scanRegion(region, x, y);
            if (region.surrounded) {
              for (Coord coord : region.coords) {
                board[coord.x][coord.y] = 'X';
              }
            }
          }
        }
      }
    }
  }

  public void solve(char[][] grid) {
    Scan s = new Scan(grid);
    s.scanRecursive();
  }
}
