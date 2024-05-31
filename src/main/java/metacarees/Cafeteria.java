package metacarees;

import java.util.Arrays;

public class Cafeteria {

  public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
    Arrays.sort(S);
    long extraSeaters = 0;
    long left = -K;
    for (int s = 0; s <= M; s++) {
      long right = s < M
          ? S[s]
          : N + K + 1;
      long spacesBetween = right - left - 1 - K;
      if (spacesBetween > 0) {
        extraSeaters += spacesBetween / (K + 1);
      }
      left = right;
    }
    return extraSeaters;
  }
}
