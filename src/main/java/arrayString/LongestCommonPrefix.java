package arrayString;

public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    for (int i = 0; true; i++) {
      String s = strs[0];
      if (i >= s.length()) {
        return "";
      }
      char c = s.charAt(i);
      for (int j = 0; j < strs.length; j++) {
        s = strs[j];
        if (i >= s.length()) {
          return s.substring(0, i);
        }
        char cc = s.charAt(i);
        if (c != cc) {
          return s.substring(0, i);
        }
      }
    }
  }
}
