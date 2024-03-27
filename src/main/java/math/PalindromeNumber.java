package math;

public class PalindromeNumber {

  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }

    int src = x;
    int reversedX = 0;

    while (src != 0) {
      reversedX = (reversedX * 10) + (src % 10);
      src /= 10;
    }
    return reversedX == x;
  }
}