package arrayString;
public class RemoveDuplicatesFromSortedArray {

  public int removeDuplicates(int[] nums) {
    int tlen = nums.length;
    for (int i = 1; i < tlen; i++) {
      if (nums[i - 1] == nums[i]) {
        for (int j = i; j < nums.length; j++) {
          nums[j - 1] = nums[j];
        }
        tlen--;
        i--;
      }
    }
    return tlen;
  }
}
