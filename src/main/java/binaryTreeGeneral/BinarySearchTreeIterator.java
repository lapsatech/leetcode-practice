package binaryTreeGeneral;

import java.util.LinkedList;

import models.binaryTree.TreeNode;

public class BinarySearchTreeIterator {

  static class BSTIterator {

    private LinkedList<TreeNode> stack = new LinkedList<>();
    private TreeNode node;

    public BSTIterator(TreeNode root) {
      this.node = root;
    }

    public int next() {
      while (!stack.isEmpty() || node != null) {
        if (node != null) {
          stack.push(node);
          node = node.left;
        } else {
          TreeNode visit = stack.pop();
          node = visit.right;
          return visit.val;
        }
      }
      throw new AssertionError("Should not happen");
    }

    public boolean hasNext() {
      return !stack.isEmpty() || node != null;
    }
  }

}
