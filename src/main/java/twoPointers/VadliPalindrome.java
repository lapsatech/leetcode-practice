package twoPointers;

public class VadliPalindrome {
  public boolean isPalindrome(String s) {

    int i1 = 0;
    int i2 = s.length() - 1;

    while (i1 < i2) {

      int c1 = s.codePointAt(i1);
      if (!Character.isAlphabetic(c1) && !Character.isDigit(c1)) {
        i1++;
        continue;
      }
      int c2 = s.codePointAt(i2);
      if (!Character.isAlphabetic(c2) && !Character.isDigit(c2)) {
        i2--;
        continue;
      }

      if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
        return false;
      }
      i1++;
      i2--;
    }
    return true;
  }
}
