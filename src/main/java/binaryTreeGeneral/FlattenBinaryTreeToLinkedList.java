package binaryTreeGeneral;

import models.binaryTree.TreeNode;

public class FlattenBinaryTreeToLinkedList {

  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    helperRecursive(root);
  }

  private TreeNode helperRecursive(TreeNode root) {
    if (root.left != null) {
      TreeNode left1 = helperRecursive(root.left);
      if (root.right != null) {
        TreeNode right1 = helperRecursive(root.right);
        TreeNode t = root.right;
        root.right = root.left;
        root.left = null;
        left1.right = t;
        return right1;
      } else {
        root.right = root.left;
        root.left = null;
        return left1;
      }
    } else {
      if (root.right != null) {
        TreeNode right1 = helperRecursive(root.right);
        return right1;
      } else {
        return root;
      }
    }
  }

}
