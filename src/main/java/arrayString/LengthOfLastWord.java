package arrayString;

public class LengthOfLastWord {
  public int lengthOfLastWord(String s) {
    int i = s.length() - 1;
    while (i >= 0 && s.charAt(i) == ' ') {
      i--;
    }
    int l = i;
    while (i >= 0 && s.charAt(i) != ' ') {
      i--;
    }
    return l - i;
  }
}
