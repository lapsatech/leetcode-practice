package matrix;

public class ValidSudoku {

  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      boolean[] byCols = new boolean[9];
      boolean[] byRows = new boolean[9];
      boolean[] bySquares = new boolean[9];
      for (int j = 0; j < 9; j++) {

        int d = idxOfRow(board, i, j);
        if (d > 0) {
          if (byRows[d - 1]) {
            return false;
          }
          byRows[d - 1] = true;
        }

        d = idxOfCol(board, i, j);
        if (d > 0) {
          if (byCols[d - 1]) {
            return false;
          }
          byCols[d - 1] = true;
        }

        d = idxOfSquare(board, i, j);
        if (d > 0) {
          if (bySquares[d - 1]) {
            return false;
          }
          bySquares[d - 1] = true;
        }
      }
    }
    return true;
  }

  private static int idxOfRow(char[][] board, int i, int j) {
    return board[i][j] == '.'
        ? -1
        : board[i][j] - 48;
  }

  private static int idxOfCol(char[][] board, int i, int j) {
    return board[j][i] == '.'
        ? -1
        : board[j][i] - 48;
  }

  private static int idxOfSquare(char[][] board, int i, int j) {
    int sqi = (((int) i / 3) * 3) + ((int) j / 3);
    int sqj = (((int) i % 3) * 3) + ((int) j % 3);
    return board[sqi][sqj] == '.'
        ? -1
        : board[sqi][sqj] - 48;
  }
}
