package arrayString;

public class RemoveDuplicatesFromSortedArrayII {

  public int removeDuplicates(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }
    int left = 1, right = 1;
    int c = nums[0];
    int len = 1;
    while (right < nums.length) {
      if (c != nums[right]) {
        c = nums[right];
        len = 1;
      } else {
        if (++len > 2) {
          right++;
          continue;
        }
      }
      nums[left] = nums[right];
      right++;
      left++;
    }
    return left;
  }
}
