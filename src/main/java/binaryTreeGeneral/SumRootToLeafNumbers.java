package binaryTreeGeneral;

import models.binaryTree.TreeNode;

public class SumRootToLeafNumbers {

  public int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return recursive(root, 0, 0);
  }

  private int recursive(TreeNode n, int total, int base) {
    int cvalue = (base * 10) + n.val;
    if (n.left == null && n.right == null) {
      // leaf
      return total + cvalue;
    }

    if (n.left != null) {
      total = recursive(n.left, total, cvalue);
    }
    if (n.right != null) {
      total = recursive(n.right, total, cvalue);
    }
    return total;
  }

}
