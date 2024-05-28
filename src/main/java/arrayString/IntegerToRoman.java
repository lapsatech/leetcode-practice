package arrayString;

import java.util.Collections;

public class IntegerToRoman {

  public String intToRoman(int num) {
    return intToRoman2(num);
  }

  public String intToRoman1(int num) {
    StringBuilder sb = new StringBuilder();
    num = help2(sb, num, 3, "M", null, null);
    num = help2(sb, num, 2, "C", "D", "M");
    num = help2(sb, num, 1, "X", "L", "C");
    num = help2(sb, num, 0, "I", "V", "X");

    return sb.toString();
  }

  public String intToRoman2(int num) {
    int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] numerals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    StringBuffer sb = new StringBuffer();
    int i = 0;

    while (num > 0) {
      if (num >= values[i]) {
        sb.append(numerals[i]);
        num -= values[i];
      } else {
        i++;
      }
    }
    return sb.toString();
  }

  private static int help2(
      StringBuilder sb,
      int num,
      int zeroes,
      String one,
      String five,
      String ten) {

    int tendiv = (int) Math.pow(10, zeroes);
    int count = num / tendiv;
    if (five == null && ten == null) {
      sb.append(String.join("", Collections.nCopies(count, one)));
    } else {
      switch (count) {
      case 9:
        sb.append(one);
        sb.append(ten);
        break;
      case 8:
        sb.append(five);
        sb.append(one);
        sb.append(one);
        sb.append(one);
        break;
      case 7:
        sb.append(five);
        sb.append(one);
        sb.append(one);
        break;
      case 6:
        sb.append(five);
        sb.append(one);
        break;
      case 5:
        sb.append(five);
        break;
      case 4:
        sb.append(one);
        sb.append(five);
        break;
      case 3:
        sb.append(one);
        sb.append(one);
        sb.append(one);
        break;
      case 2:
        sb.append(one);
        sb.append(one);
        break;
      case 1:
        sb.append(one);
        break;
      case 0:
        break;
      default:
        throw new AssertionError();
      }
    }
    return num % tendiv;
  }

}
