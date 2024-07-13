package binarySearchTree;

import java.util.LinkedList;

import models.binaryTree.TreeNode;

public class ValidateBinarySearchTree {

  public boolean isValidBST(TreeNode root) {

    TreeNode prev = null, node = root;

    LinkedList<TreeNode> stack = new LinkedList<>();

    while (!stack.isEmpty() || node != null) {
      if (node != null) {
        stack.addLast(node);
        node = node.left;
      } else {
        node = stack.removeLast();
        if (prev == null) {
          prev = node;
        } else {
          if (node.val <= prev.val) {
            return false;
          }
          prev = node;
        }
        node = node.right;
      }
    }

    return true;

  }

}
