package arrayString;

public class JumpGame {

  private static int positionAfterMaxPossibleJump(int position, int[] nums) {
    return Math.min(position + nums[position], nums.length - 1);
  }

  // recursive
  private static boolean canJump1(int[] nums) {
    return canJumpFrom1(nums, 0);
  }

  private static boolean canJumpFrom1(int[] nums, int position) {

    if (position == nums.length - 1) {
      return true;
    }

    final int positionAfterMaxPossibleJump = positionAfterMaxPossibleJump(position, nums);

    for (int nextPosiblePos = positionAfterMaxPossibleJump; nextPosiblePos > position; nextPosiblePos--) {
      boolean canJump = canJumpFrom1(nums, nextPosiblePos);
      if (canJump) {
        return true;
      }
    }
    return false;
  }

  // memoization
  private static boolean canJump2(int[] nums) {
    return canJumpFrom2(nums, 0, new boolean[nums.length]);
  }

  private static boolean canJumpFrom2(int[] nums, int position, boolean[] dp) {
    if (position == nums.length - 1) {
      return true;
    }

    final int positionAfterMaxPossibleJump = positionAfterMaxPossibleJump(position, nums);

    for (int nextPosiblePos = positionAfterMaxPossibleJump; nextPosiblePos > position; nextPosiblePos--) {
      if (!dp[nextPosiblePos]) {
        dp[nextPosiblePos] = true;
        boolean canJump = canJumpFrom2(nums, nextPosiblePos, dp);
        if (canJump) {
          return true;
        }
      }
    }
    return false;
  }

  // get rid of recursion
  private static boolean canJump3(int[] nums) {
    boolean[] index = new boolean[nums.length];

    index[nums.length - 1] = true;

    for (int position = nums.length - 1 - 1; position >= 0; position--) {
      final int positionAfterMaxPossibleJump = positionAfterMaxPossibleJump(position, nums);
      for (int posiblePos = position + 1; posiblePos <= positionAfterMaxPossibleJump; posiblePos++) {
        if (index[posiblePos]) {
          index[position] = true;
          break;
        }
      }
    }

    return index[0];
  }

  // mem optimization - greedy
  private static boolean canJump4(int[] nums) {
    int lastGoodPosition = nums.length - 1;
    for (int position = nums.length - 1 - 1; position >= 0; position--) {
      final int positionAfterMaxPossibleJump = positionAfterMaxPossibleJump(position, nums);
      if (positionAfterMaxPossibleJump >= lastGoodPosition) {
        lastGoodPosition = position;
      }
    }
    return lastGoodPosition == 0;
  }

  public boolean canJump(int[] nums) {
    return canJump4(nums);
  }

  public static void main(String[] args) {
    int[] ar1 = { 2, 3, 1, 1, 4 };
    System.out.println(JumpGame.canJump1(ar1));
    System.out.println(JumpGame.canJump2(ar1));
    System.out.println(JumpGame.canJump3(ar1));
    System.out.println(JumpGame.canJump4(ar1));
    int[] ar2 = { 3, 2, 1, 0, 4 };
    System.out.println(JumpGame.canJump1(ar2));
    System.out.println(JumpGame.canJump2(ar2));
    System.out.println(JumpGame.canJump3(ar2));
    System.out.println(JumpGame.canJump4(ar2));
  }
}
