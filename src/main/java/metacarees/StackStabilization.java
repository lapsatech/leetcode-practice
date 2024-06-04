package metacarees;

public class StackStabilization {

  public int getMinimumDeflatedDiscCount(int N, int[] R) {
    int counter = 0;
    for (int i = N - 2; i >= 0; i--) {
      if (R[i] >= R[i + 1]) {
        R[i] = R[i + 1] - 1;
        if (R[i] < 1) {
          return -1;
        }
        counter++;
      }
    }

    return counter;
  }
}
