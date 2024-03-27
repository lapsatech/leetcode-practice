package binaryTreeGeneral;

import models.binaryTree.TreeNode;

public class InvertBinaryTree {

  public TreeNode invertTree(TreeNode root) {
    return invertTreeRecursive(root);
  }

  public TreeNode invertTreeRecursive(TreeNode root) {
    if (root == null) {
      return null;
    }
    return new TreeNode(root.val, invertTreeRecursive(root.right), invertTreeRecursive(root.left));
  }

}
