package binaryTreeBFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import models.binaryTree.TreeNode;

public class BinaryTreeRightSideView {
  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>();
    LinkedList<TreeNode> fifo = new LinkedList<>();

    fifo.addFirst(root);

    while (!fifo.isEmpty()) {
      int lcount = fifo.size();

      TreeNode mostRight = null;
      for (int i = 0; i < lcount; i++) {
        TreeNode t = fifo.removeLast();
        if (mostRight == null) {
          mostRight = t;
        }

        if (t.right != null) {
          fifo.addFirst(t.right);
        }
        if (t.left != null) {
          fifo.addFirst(t.left);
        }
      }
      result.add(mostRight.val);
    }

    return result;
  }

}
