package matrix;

public class ValidSudoku {

  public boolean isValidSudoku(char[][] board) {
    for (int i1 = 0; i1 < 9; i1++) {
      boolean[] tableByRows = new boolean[9];
      boolean[] tableByCols = new boolean[9];
      boolean[] tableBySubsquares = new boolean[9];
      for (int i2 = 0; i2 < 9; i2++) {
        if (!validate(tableByRows, valueOfRow(board, i1, i2))) {
          return false;
        }
        if (!validate(tableByCols, valueOfCol(board, i1, i2))) {
          return false;
        }
        if (!validate(tableBySubsquares, valueOfSubsquare(board, i1, i2))) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean validate(boolean[] memoTable, char value) {
    if (value == '.') {
      return true;
    }
    if (memoTable[value - 49]) {
      return false;
    }
    memoTable[value - 49] = true;
    return true;
  }

  private static char valueOfRow(char[][] board, int i1, int i2) {
    return board[i1][i2];
  }

  private static char valueOfCol(char[][] board, int i1, int i2) {
    return board[i2][i1];
  }

  private static char valueOfSubsquare(char[][] board, int i1, int i2) {
    int j1 = (((int) i1 / 3) * 3) + ((int) i2 / 3);
    int j2 = (((int) i1 % 3) * 3) + ((int) i2 % 3);
    return board[j1][j2];
  }
}
