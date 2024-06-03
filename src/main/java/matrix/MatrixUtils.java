package matrix;

import java.util.Collections;
import java.util.function.Consumer;

public class MatrixUtils {

  public static void dumpMatrix(int[][] matrix) {
    dumpMatrix(matrix, System.out::print);
  }

  public static void dumpMatrix(int[][] matrix, Consumer<String> printer) {
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

    printer.accept(String.join("", Collections.nCopies(rowNumLength, " ")) + "   ");
    for (int c = 0; c < maxCols; c++) {
      printer.accept(String.format("%" + colLength + "d", c) + " ");
    }
    printer.accept(System.lineSeparator());

    for (int i = 0; i < matrix.length; i++) {
      printer.accept(String.format("%" + rowNumLength + "d", i) + " : ");
      for (int j = 0; j < matrix[i].length; j++) {
        printer.accept(String.format("%" + colLength + "d", matrix[i][j]) + " ");
      }
      printer.accept(System.lineSeparator());
    }
  }

}
