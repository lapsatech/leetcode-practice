package stack;

import java.util.LinkedList;

public class ValidParentheses {

  public boolean isValid(String s) {
    LinkedList<Character> stack = new LinkedList<>();

    char top = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
      case '(':
        if (top != 0) {
          stack.push(Character.valueOf(top));
        }
        top = ')';
        break;
      case '[':
        if (top != 0) {
          stack.push(Character.valueOf(top));
        }
        top = ']';
        break;
      case '{':
        if (top != 0) {
          stack.push(Character.valueOf(top));
        }
        top = '}';
        break;
      case ')':
      case ']':
      case '}':
        if (top != c) {
          return false;
        }
        if (stack.isEmpty()) {
          top = 0;
        } else {
          top = stack.pop().charValue();
        }
        break;
      default:
        return false;
      }
    }
    return top == 0 && stack.isEmpty();
  }
}
