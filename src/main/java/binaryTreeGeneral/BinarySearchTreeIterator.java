package binaryTreeGeneral;

import java.util.Deque;
import java.util.LinkedList;

import models.binaryTree.BinaryTreeNode;

public class BinarySearchTreeIterator {

  static class BSTIterator {

    private Deque<BinaryTreeNode> lifo = new LinkedList<>();
    private BinaryTreeNode node;

    public BSTIterator(BinaryTreeNode root) {
      this.node = root;
    }

    public int next() {
      while (!lifo.isEmpty() || node != null) {
        if (node != null) {
          lifo.push(node);
          node = node.left;
        } else {
          BinaryTreeNode visit = lifo.pop();
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
