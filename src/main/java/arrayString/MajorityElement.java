package arrayString;

import java.util.Arrays;

public class MajorityElement {

  public int majorityElement(int[] nums) {
    Arrays.sort(nums);

    int majorCount = 1;
    int major = nums[0];
    int maxMajorCount = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        majorCount++;
        if (majorCount > maxMajorCount) {
          maxMajorCount = majorCount;
          major = nums[i];
        }
      } else {
        majorCount = 1;
      }
    }

    return major;
  }
}
