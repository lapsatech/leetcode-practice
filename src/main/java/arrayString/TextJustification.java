package arrayString;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TextJustification {

  public List<String> fullJustify(String[] words, int maxWidth) {

    class Line {

      final Deque<String> words = new LinkedList<>();
      int wordsTotalLength = 0;
      int stringMinLength = -1;

      void push(String word) {
        this.wordsTotalLength += word.length();
        this.words.addLast(word);
        this.stringMinLength = this.wordsTotalLength + this.words.size() - 1;
      }

      String pop() {
        String word = this.words.removeLast();
        this.wordsTotalLength -= word.length();
        this.stringMinLength = this.wordsTotalLength + this.words.size() - 1;
        return word;
      }

      String justify(int maxLength, boolean leftAligned) {
        StringBuilder sb = new StringBuilder();

        int minSpacerLength = 1, lackOfSpaces = 0;
        if (this.words.size() > 1 && !leftAligned) {
          minSpacerLength = (maxLength - this.wordsTotalLength) / (this.words.size() - 1);
          lackOfSpaces = maxLength - ((minSpacerLength * (this.words.size() - 1)) + this.wordsTotalLength);
        }

        sb.append(this.words.removeFirst());

        while (!this.words.isEmpty()) {
          for (int i = 0; i < minSpacerLength; i++) {
            sb.append(' ');
          }
          if (lackOfSpaces > 0) {
            sb.append(' ');
            lackOfSpaces--;
          }
          sb.append(this.words.removeFirst());
        }

        while (sb.length() < maxLength) {
          sb.append(' ');
        }
        return sb.toString();

      }
    }

    Deque<Line> lines = new LinkedList<>();
    Line line = null;

    for (int i = 0; i < words.length; i++) {
      if (line == null) {
        lines.addLast(line = new Line());
      }
      line.push(words[i]);
      if (line.stringMinLength >= maxWidth) {
        if (line.stringMinLength > maxWidth) {
          // rollback latest word
          i--;
          line.pop();
        }
        // wrap line
        line = null;
      }

    }

    ArrayList<String> result = new ArrayList<>(lines.size());

    while (!lines.isEmpty()) {
      line = lines.removeFirst();
      result.add(line.justify(maxWidth, lines.isEmpty()));
    }
    return result;
  }

}
