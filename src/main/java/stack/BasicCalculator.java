package stack;

import java.util.LinkedList;

public class BasicCalculator {

  public int calculate(String s) {
    return calculate(new StringScanner(s));
  }

  private int calculate(StringScanner s) {

    ValuesCollection values = new ValuesCollection();

    while (s.hasNext()) {

      final char cur = s.next();

      if (cur == ' ') {
        if (!values.top().isEmpty()) {
          values.add();
        }
        continue;
      }

      if (Character.isDigit(cur)) {
        values.top().mergeDigit(cur);
        continue;
      }

      if (cur == '+') {
        if (!values.top().isEmpty()) {
          values.add();
        }
        continue;
      }

      if (cur == '-') {
        if (!values.top().isEmpty()) {
          values.add();
        }
        values.top().inverseSign();
        continue;
      }

      if (cur == '(') {
        if (!values.top().isEmpty()) {
          throw new IllegalArgumentException("Syntax error. Unexpected opening brace '('");
        }

        values.top().setValue(calculate(s));
        continue;
      }

      if (cur == ')') {
        break;
      }
    }
    return values.sum();
  }

}

class StringScanner {

  private final String s;
  private int pos = -1;

  public StringScanner(String s) {
    this.s = s;
  }

  public boolean hasNext() {
    return pos + 1 < s.length();
  }

  public char next() {
    if (!hasNext()) {
      throw new IllegalStateException("End of string");
    }
    pos++;
    return s.charAt(pos);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(s.substring(0, pos + 1));
    sb.append('_');
    sb.append(s.substring(pos + 1));
    return sb.toString();
  }
}

class ValuesCollection {
  private final LinkedList<Value> values = new LinkedList<>();

  public ValuesCollection() {
    values.add(new Value());
  }

  public Value add() {
    Value v = new Value();
    values.addFirst(v);
    return v;
  }

  public Value top() {
    return values.element();
  }

  public int sum() {
    int result = 0;
    for (Value v : values) {
      result += v.toValue();
    }
    return result;
  }
}

class Value {
  private boolean positive;
  private int value;
  private boolean empty = true;

  public Value(boolean positive) {
    this.positive = positive;
  }

  public Value setValue(int value) {
    if (!this.empty) {
      throw new IllegalStateException("Value is not empty");
    }
    this.value = value;
    this.empty = false;
    return this;
  }

  public Value(
      boolean positive,
      int value) {
    this.positive = positive;
    this.value = value;
    this.empty = false;
  }

  public Value inverseSign() {
    this.positive = !this.positive;
    return this;
  }

  public Value(int value) {
    this.positive = true;
    this.value = value;
    this.empty = false;
  }

  public Value() {
    this.positive = true;
  }

  public int toValue() {
    return positive ? value : -value;
  }

  public boolean isEmpty() {
    return empty;
  }

  @Override
  public String toString() {
    return (positive ? "+" : "-") + value;
  }

  public Value mergeDigit(char digit) {
    if (!Character.isDigit(digit)) {
      throw new IllegalArgumentException("Is not a digit");
    }
    value *= 10;
    value += digit - '0';
    empty = false;
    return this;
  }

}