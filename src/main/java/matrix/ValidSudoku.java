package matrix;

public class ValidSudoku {

  public boolean isValidSudoku(char[][] board) {
    for (int i1 = 0; i1 < 9; i1++) {
      boolean[] byCols = new boolean[9];
      boolean[] byRows = new boolean[9];
      boolean[] bySquares = new boolean[9];
      for (int i2 = 0; i2 < 9; i2++) {

        int d = idxOfRow(board, i1, i2);
        if (d > 0) {
          if (byRows[d - 1]) {
            return false;
          }
          byRows[d - 1] = true;
        }

        d = idxOfCol(board, i1, i2);
        if (d > 0) {
          if (byCols[d - 1]) {
            return false;
          }
          byCols[d - 1] = true;
        }

        d = idxOfSquare(board, i1, i2);
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

  private static int idxOfRow(char[][] board, int i1, int i2) {
    return board[i1][i2] == '.'
        ? -1
        : board[i1][i2] - 48;
  }

  private static int idxOfCol(char[][] board, int i1, int i2) {
    return board[i2][i1] == '.'
        ? -1
        : board[i2][i1] - 48;
  }

  private static int idxOfSquare(char[][] board, int i1, int i2) {
    int i = (((int) i1 / 3) * 3) + ((int) i2 / 3);
    int j = (((int) i1 % 3) * 3) + ((int) i2 % 3);
    return board[i][j] == '.'
        ? -1
        : board[i][j] - 48;
  }
}
