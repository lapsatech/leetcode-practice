package binaryTreeGeneral;

import java.util.LinkedList;

import models.binaryTree.TreeNode;

public class SameTree {

  public boolean isSameTreeRecurrent(TreeNode p, TreeNode q) {
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

  public boolean isSameTree(TreeNode p, TreeNode q) {
    return isSameTreeRecurrent(p, q);
  }

  public boolean isSameTreeVisitor(TreeNode p, TreeNode q) {
    LinkedList<TreeNode> qQ = new LinkedList<>();
    LinkedList<TreeNode> pQ = new LinkedList<>();

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
