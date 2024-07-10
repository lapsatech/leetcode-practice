package binaryTreeBFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import models.binaryTree.TreeNode;

public class AverageOfLevelsInBinaryTree {

  public List<Double> averageOfLevels(TreeNode root) {
    if (root == null) {
      throw new IllegalArgumentException();
    }
    List<Double> result = new ArrayList<>();
    Deque<TreeNode> queue = new LinkedList<>();

    queue.addFirst(root);

    while (!queue.isEmpty()) {
      long lsum = 0;
      int lcount = queue.size();
      for (int i = 0; i < lcount; i++) {
        TreeNode t = queue.removeLast();
        lsum += t.val;
        if (t.left != null) {
          queue.addFirst(t.left);
        }
        if (t.right != null) {
          queue.addFirst(t.right);
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
