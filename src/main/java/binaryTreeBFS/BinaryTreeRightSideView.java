package binaryTreeBFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import models.binaryTree.BinaryTreeNode;

public class BinaryTreeRightSideView {
  public List<Integer> rightSideView(BinaryTreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>();
    LinkedList<BinaryTreeNode> fifo = new LinkedList<>();

    fifo.addFirst(root);

    while (!fifo.isEmpty()) {
      int lcount = fifo.size();

      BinaryTreeNode mostRight = null;
      for (int i = 0; i < lcount; i++) {
        BinaryTreeNode t = fifo.removeLast();
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
