package arrayString;

public class ProductOfArrayExceptSelf {

  public int[] productExceptSelf(int[] nums) {
    int[] answer = new int[nums.length];

    boolean zeroPresent = false;
    int productExceptZeroes = 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        if (zeroPresent) {
          return answer; // more than two zeroes - always be 0 array
        }
        zeroPresent = true;
      } else {
        productExceptZeroes *= nums[i];
      }
    }
    for (int i = 0; i < nums.length; i++) {
      answer[i] = zeroPresent
          ? nums[i] == 0
              ? productExceptZeroes
              : 0
          : productExceptZeroes / nums[i];
    }
    return answer;
  }
}
