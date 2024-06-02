package matrix;

import java.util.Collections;

public class MatrixUtils {

  public static void dumpMatrix(int[][] matrix) {
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

}
