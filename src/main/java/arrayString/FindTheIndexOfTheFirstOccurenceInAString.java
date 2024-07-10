package arrayString;

public class FindTheIndexOfTheFirstOccurenceInAString {

  public int strStr(String haystack, String needle) {
    int max = haystack.length() - needle.length() + 1;
    int j;
    MAIN_LOOP: for (int i = 0; i < max; i++) {
      if (haystack.charAt(i) == needle.charAt(0)) {
        for (j = 1; j < needle.length(); j++) {
          if (haystack.charAt(i + j) != needle.charAt(j)) {
            continue MAIN_LOOP;
          }
        }
        return i;
      }
    }
    return -1;
  }

}
