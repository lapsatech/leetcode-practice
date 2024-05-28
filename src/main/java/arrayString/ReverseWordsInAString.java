package arrayString;

import java.util.StringJoiner;

public class ReverseWordsInAString {
  public String reverseWords(String s) {
    char[] charar = s.toCharArray();
    StringJoiner sj = new StringJoiner(" ");
    int rightIndex, leftIndex = charar.length;
    while (leftIndex >= 0) {
      leftIndex--;
      while (leftIndex >= 0 && charar[leftIndex] == ' ') {
        leftIndex--;
      }
      rightIndex = leftIndex;
      while (leftIndex >= 0 && charar[leftIndex] != ' ') {
        leftIndex--;
      }
      if (rightIndex > leftIndex) {
        // found word
        sj.add(new String(charar, leftIndex + 1, rightIndex - leftIndex));
      }
    }
    return sj.toString();
  }
}
