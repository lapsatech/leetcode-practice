package math;

public class PowerOfTwo {

  public boolean isPowerOfTwo(int n) {
    if (n == 0) {
      return false;
    }
    while (true) {
      if (n == 1) {
        return true;
      }
      if (n % 2 == 0) {
        n = n / 2;
        continue;
      }
      return false;
    }
  }

  public static void main(String[] args) {
    PowerOfTwo c = new PowerOfTwo();
    System.out.println(c.isPowerOfTwo(1));
    System.out.println(c.isPowerOfTwo(16));
    System.out.println(c.isPowerOfTwo(3));
  }

}
