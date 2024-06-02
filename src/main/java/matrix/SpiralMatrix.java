package matrix;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SpiralMatrix {

  private static enum Dir {
    LEFT, DOWN, RIGHT, UP;
  }

  public List<Integer> spiralOrder(int[][] matrix) {
    return Arrays.stream(spiralOrderAry(matrix)).boxed().collect(Collectors.toList());
  }

  private int[] spiralOrderAry(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    int i = 0, x = 0, y = 0, level = 0;
    Dir dir = Dir.RIGHT;

    int[] res = new int[m * n];

    while (i < res.length) {
      res[i] = matrix[y][x];
      switch (dir) {
      case RIGHT:
        if (x == m - 1 - level) {
          dir = Dir.DOWN;
          continue;
        }
        x++;
        break;
      case DOWN:
        if (y == n - 1 - level) {
          dir = Dir.LEFT;
          continue;
        }
        y++;
        break;
      case LEFT:
        if (x == level) {
          dir = Dir.UP;
          continue;
        }
        x--;
        break;
      case UP:
        if (y - 1 == level) {
          dir = Dir.RIGHT;
          level++;
          continue;
        }
        y--;
        break;
      }
      i++;
    }

    return res;
  }

  public static void main(String[] args) {
    SpiralMatrix s = new SpiralMatrix();
    int[][] ary = new int[][] {
        new int[] { 1, 2, 3 },
        new int[] { 8, 9, 4 },
        new int[] { 7, 6, 5 }
    };
    MatrixUtils.dumpMatrix(ary);
    Arrays.toString(s.spiralOrderAry(ary));
  }

}
