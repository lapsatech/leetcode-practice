package binaryTreeGeneral;

import java.util.LinkedList;
import java.util.Queue;

import models.binaryTree.TreeNode;

public class SymmetricTree {

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }

    Queue<TreeNode> lQ = new LinkedList<>();
    Queue<TreeNode> rQ = new LinkedList<>();

    lQ.add(root.left);
    rQ.add(root.right);

    while (!lQ.isEmpty() && !rQ.isEmpty()) {
      TreeNode l = lQ.remove();
      TreeNode r = rQ.remove();

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
