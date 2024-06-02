package matrix;

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

  public static void main(String[] args) {
    SpiralMatrixII s = new SpiralMatrixII();
    MatrixUtils.dumpMatrix(s.generateMatrix(5));
    System.out.println();
    MatrixUtils.dumpMatrix(s.generateMatrix(4));
    System.out.println();
    MatrixUtils.dumpMatrix(s.generateMatrix(13));
    System.out.println();
    MatrixUtils.dumpMatrix(s.generateMatrix(1));
    System.out.println();
    MatrixUtils.dumpMatrix(s.generateMatrix(2));
    System.out.println();
  }

}
