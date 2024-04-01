package arrayString;

public class RotateArray {

  public void rotate(int[] nums, final int k) {

    final int len = nums.length;
    if (len < 2) {
      return;
    }

    final int shift = (len + (k % len)) % len;
    if (shift == 0) {
      return;
    }

    final int templen = len - shift;
    int[] cache = new int[templen];

    for (int i = 0; i < templen; i++) {
      cache[i] = nums[i];
    }
    for (int i = 0; i < shift; i++) {
      nums[i] = nums[len - shift + i];
    }
    for (int i = 0; i < templen; i++) {
      nums[i + shift] = cache[i];
    }
  }
}
