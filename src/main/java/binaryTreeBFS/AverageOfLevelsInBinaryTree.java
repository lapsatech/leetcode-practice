package binaryTreeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import models.binaryTree.TreeNode;

public class AverageOfLevelsInBinaryTree {

  public List<Double> averageOfLevels(TreeNode root) {
    if (root == null) {
      throw new IllegalArgumentException();
    }
    List<Double> result = new ArrayList<>();
    LinkedList<TreeNode> q = new LinkedList<>();

    q.addFirst(root);

    while (!q.isEmpty()) {
      long lsum = 0;
      int lcount = q.size();
      for (int i = 0; i < lcount; i++) {
        TreeNode t = q.removeFirst();
        lsum += t.val;
        if (t.left != null) {
          q.addLast(t.left);
        }
        if (t.right != null) {
          q.addLast(t.right);
        }
      }
      result.add(
          lcount > 0
              ? (double) lsum / (double) lcount
              : 0);
    }
    return result;

  }

}
