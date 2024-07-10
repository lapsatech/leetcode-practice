package binaryTreeGeneral;

import java.util.LinkedList;

import models.binaryTree.BinaryTreeNode;

public class SameTree {

  public boolean isSameTreeRecurrent(BinaryTreeNode p, BinaryTreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    return true
        && !(p == null && q != null)
        && !(p != null && q == null)
        && (p.val == q.val)
        && isSameTreeRecurrent(p.left, q.left)
        && isSameTreeRecurrent(p.right, q.right);
  }

  public boolean isSameTree(BinaryTreeNode p, BinaryTreeNode q) {
    return isSameTreeRecurrent(p, q);
  }

  public boolean isSameTreeVisitor(BinaryTreeNode p, BinaryTreeNode q) {
    LinkedList<BinaryTreeNode> qQ = new LinkedList<>();
    LinkedList<BinaryTreeNode> pQ = new LinkedList<>();

    qQ.add(q);
    pQ.add(p);

    while (!pQ.isEmpty() && !qQ.isEmpty()) {

      p = pQ.remove();
      q = qQ.remove();

      if (q == null && p == null) {
        continue;
      }

      if (q == null && p != null) {
        return false;
      }
      if (q != null && p == null) {
        return false;
      }

      if (p.val != q.val) {
        return false;
      }

      pQ.add(p.left);
      qQ.add(q.left);

      pQ.add(p.right);
      qQ.add(q.right);

    }
    return true;
  }

}
