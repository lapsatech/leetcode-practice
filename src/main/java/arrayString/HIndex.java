package arrayString;

import java.util.Arrays;

public class HIndex {

  public int hIndex(int[] citations) {
    Arrays.sort(citations);

    int hIndex = 0;
    for (int i = citations.length; i > 0; i--) {
      int citationCount = citations[i - 1];
      int articles = citations.length - i + 1;
      if (articles <= citationCount) {
        hIndex = articles;
      }
    }

    return hIndex;

  }
}
