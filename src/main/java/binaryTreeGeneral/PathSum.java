package binaryTreeGeneral;

import models.binaryTree.BinaryTreeNode;

public class PathSum {

  public boolean hasPathSum(BinaryTreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    return hasPathSum(root, 0, targetSum);
  }

  private boolean hasPathSum(BinaryTreeNode root, int base, int expectSum) {
    base += root.val;
    return (root.left == null && root.right == null && base == expectSum)
        || (root.left != null && hasPathSum(root.left, base, expectSum))
        || (root.right != null && hasPathSum(root.right, base, expectSum));
  }

}
