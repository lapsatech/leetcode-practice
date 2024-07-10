package binaryTreeGeneral;

import java.util.LinkedList;
import java.util.Queue;

import models.binaryTree.BinaryTreeNode;

public class SymmetricTree {

  public boolean isSymmetric(BinaryTreeNode root) {
    if (root == null) {
      return true;
    }

    Queue<BinaryTreeNode> lQ = new LinkedList<>();
    Queue<BinaryTreeNode> rQ = new LinkedList<>();

    lQ.add(root.left);
    rQ.add(root.right);

    while (!lQ.isEmpty() && !rQ.isEmpty()) {
      BinaryTreeNode l = lQ.remove();
      BinaryTreeNode r = rQ.remove();

      if (l == null && r == null) {
        continue;
      }
      if (l == null && r != null) {
        return false;
      }
      if (l != null && r == null) {
        return false;
      }
      if (l.val != r.val) {
        return false;
      }

      lQ.add(l.left);
      lQ.add(l.right);

      rQ.add(r.right);
      rQ.add(r.left);
    }
    return true;

  }

}
