package binaryTreeGeneral;

import models.binaryTree.TreeNode;

public class PathSum {

  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    return hasPathSum(root, 0, targetSum);
  }

  private boolean hasPathSum(TreeNode root, int base, int expectSum) {
    base += root.val;
    return (root.left == null && root.right == null && base == expectSum)
        || (root.left != null && hasPathSum(root.left, base, expectSum))
        || (root.right != null && hasPathSum(root.right, base, expectSum));
  }

}
