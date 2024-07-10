package binaryTreeGeneral;

import models.binaryTree.BinaryTreeNode;

public class FlattenBinaryTreeToLinkedList {

  public void flatten(BinaryTreeNode root) {
    if (root == null) {
      return;
    }
    helperRecursive(root);
  }

  private BinaryTreeNode helperRecursive(BinaryTreeNode root) {
    if (root.left != null) {
      BinaryTreeNode left1 = helperRecursive(root.left);
      if (root.right != null) {
        BinaryTreeNode right1 = helperRecursive(root.right);
        BinaryTreeNode t = root.right;
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
        BinaryTreeNode right1 = helperRecursive(root.right);
        return right1;
      } else {
        return root;
      }
    }
  }

}
