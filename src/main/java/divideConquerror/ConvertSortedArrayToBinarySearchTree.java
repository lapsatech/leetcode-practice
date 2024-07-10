package divideConquerror;

import models.binaryTree.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

  public TreeNode sortedArrayToBST(int[] nums) {
    return bst(nums, 0, nums.length);
  }

  private TreeNode bst(int[] nums, int leftInclusive, int rightExclusive) {
    if (leftInclusive >= rightExclusive) {
      return null;
    }

    int center = leftInclusive + ((rightExclusive - leftInclusive) / 2);

    TreeNode tn = new TreeNode(nums[center]);
    tn.left = bst(nums, leftInclusive, center);
    tn.right = bst(nums, center + 1, rightExclusive);

    return tn;
  }
}
