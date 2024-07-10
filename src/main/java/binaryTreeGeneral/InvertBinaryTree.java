package binaryTreeGeneral;

import models.binaryTree.BinaryTreeNode;

public class InvertBinaryTree {

  public BinaryTreeNode invertTree(BinaryTreeNode root) {
    return invertTreeRecursive(root);
  }

  public BinaryTreeNode invertTreeRecursive(BinaryTreeNode root) {
    if (root == null) {
      return null;
    }
    return new BinaryTreeNode(root.val, invertTreeRecursive(root.right), invertTreeRecursive(root.left));
  }

}
