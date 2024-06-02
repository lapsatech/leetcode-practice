package matrix;

import java.util.Collections;

public class SpiralMatrixII {

  public int[][] generateMatrix(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException("N must be >0");
    }
    int spiral[][] = new int[n][n];
    int base = 1;
    for (int level = 0; level < n / 2; level++) {
      int levelLength = n - level - level - 1;
      for (int i = 0; i < levelLength; i++) {
        spiral[level][i + level] = base + i;
        spiral[level + i][n - level - 1] = base + i + levelLength;
        spiral[n - level - 1][n - i - level - 1] = base + i + (2 * levelLength);
        spiral[n - i - level - 1][level] = base + i + (3 * levelLength);
      }
      base += 4 * levelLength;
    }

    if (n % 2 == 1) {
      int center = n / 2;
      spiral[center][center] = n * n;
    }

    return spiral;
  }

  private void dumpFormat(int[][] matrix) {
    int maxValue = 0;
    int maxCols = 0;
    for (int i = 0; i < matrix.length; i++) {
      maxValue = maxValue < matrix[i].length ? matrix[i].length : maxValue;
      for (int j = 0; j < matrix[i].length; j++) {
        maxValue = maxValue < matrix[i][j] ? matrix[i][j] : maxValue;
        maxCols = maxCols < matrix[i].length ? matrix[i].length : maxCols;
      }
    }
    int colLength = 1;
    for (; Math.pow(10, colLength) <= maxValue; colLength++) {
    }
    int rowNumLength = 1;
    for (; Math.pow(10, rowNumLength) <= matrix.length; rowNumLength++) {
    }

    System.out.print(String.join("", Collections.nCopies(rowNumLength, " ")) + "   ");
    for (int c = 0; c < maxCols; c++) {
      System.out.print(String.format("%" + colLength + "d", c) + " ");
    }
    System.out.println();

    for (int i = 0; i < matrix.length; i++) {
      System.out.print(String.format("%" + rowNumLength + "d", i) + " : ");
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(String.format("%" + colLength + "d", matrix[i][j]) + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    SpiralMatrixII s = new SpiralMatrixII();
    s.dumpFormat(s.generateMatrix(5));
    System.out.println();
    s.dumpFormat(s.generateMatrix(4));
    System.out.println();
    s.dumpFormat(s.generateMatrix(13));
    System.out.println();
    s.dumpFormat(s.generateMatrix(1));
    System.out.println();
    s.dumpFormat(s.generateMatrix(2));
    System.out.println();
  }

}
