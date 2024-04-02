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

  public void rotateSorting(int[] nums, final int k) {

    final int len = nums.length;
    if (len < 2) {
      return;
    }

    final int shift = (len + (k % len)) % len;
    if (shift == 0) {
      return;
    }

    final int middle = len - shift;

    final int leftCount = middle / 2;
    for (int i = 0; i < leftCount; i++) {
      int z = nums[i];
      nums[i] = nums[middle - i - 1];
      nums[middle - i - 1] = z;
    }

    final int rightCount = (len - middle) / 2;
    for (int i = 0; i < rightCount; i++) {
      int z = nums[middle + i];
      nums[middle + i] = nums[len - i - 1];
      nums[len - i - 1] = z;
    }

    final int totalCount = len / 2;
    for (int i = 0; i < totalCount; i++) {
      int z = nums[i];
      nums[i] = nums[len - i - 1];
      nums[len - i - 1] = z;
    }

  }
}
