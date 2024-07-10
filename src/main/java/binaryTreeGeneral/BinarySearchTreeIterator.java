package binaryTreeGeneral;

import java.util.Deque;
import java.util.LinkedList;

import models.binaryTree.TreeNode;

public class BinarySearchTreeIterator {

  static class BSTIterator {

    private Deque<TreeNode> lifo = new LinkedList<>();
    private TreeNode node;

    public BSTIterator(TreeNode root) {
      this.node = root;
    }

    public int next() {
      while (!lifo.isEmpty() || node != null) {
        if (node != null) {
          lifo.push(node);
          node = node.left;
        } else {
          TreeNode visit = lifo.pop();
          node = visit.right;
          return visit.val;
        }
      }
      throw new AssertionError("Should not happen");
    }

    public boolean hasNext() {
      return !lifo.isEmpty() || node != null;
    }
  }

}
