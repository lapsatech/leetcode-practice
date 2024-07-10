package binaryTreeBFS;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import models.binaryTree.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new LinkedList<>();

    Deque<TreeNode> fifo = new LinkedList<>();
    fifo.addFirst(root);

    boolean reverse = false;
    while (!fifo.isEmpty()) {
      int lsize = fifo.size();
      LinkedList<Integer> level = new LinkedList<>();
      for (int i = 0; i < lsize; i++) {
        TreeNode n = fifo.removeLast();
        if (!reverse) {
          level.addLast(n.val);
        } else {
          level.addFirst(n.val);
        }

        if (n.left != null) {
          fifo.addFirst(n.left);
        }
        if (n.right != null) {
          fifo.addFirst(n.right);
        }
      }
      reverse = !reverse;
      result.add(level);

    }
    return result;
  }

}
