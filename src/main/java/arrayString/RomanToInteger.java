package arrayString;

public class RomanToInteger {

  public int romanToInt(String s) {
    int len = s.length();
    int result = 0;
    for (int i = 0; i < len; i++) {
      int v = charToInt(s.charAt(i));
      switch (v) {
      case 1: {
        int nv = i + 1 < len ? charToInt(s.charAt(i + 1)) : 0;
        switch (nv) {
        case 5:
          v = 4;
          i++;
          break;
        case 10:
          v = 9;
          i++;
          break;
        }
      }
        break;

      case 10: {
        int nv = i + 1 < len ? charToInt(s.charAt(i + 1)) : 0;
        switch (nv) {
        case 50:
          v = 40;
          i++;
          break;
        case 100:
          v = 90;
          i++;
          break;
        }
      }
        break;

      case 100: {
        int nv = i + 1 < len ? charToInt(s.charAt(i + 1)) : 0;
        switch (nv) {
        case 500:
          v = 400;
          i++;
          break;
        case 1000:
          v = 900;
          i++;
          break;
        }
      }
        break;

      default:
      }
      result += v;
    }
    return result;
  }

  public int charToInt(char c) {
    switch (c) {
    case 'I':
      return 1;
    case 'V':
      return 5;
    case 'X':
      return 10;
    case 'L':
      return 50;
    case 'C':
      return 100;
    case 'D':
      return 500;
    case 'M':
      return 1000;
    default:
      throw new IllegalArgumentException("Wrong symbol " + c);
    }
  }
}
