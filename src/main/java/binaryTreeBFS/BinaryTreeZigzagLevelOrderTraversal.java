package binaryTreeBFS;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import models.binaryTree.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new LinkedList<>();

    LinkedList<TreeNode> q = new LinkedList<>();
    q.add(root);

    boolean reverse = false;
    while (!q.isEmpty()) {
      int lsize = q.size();
      LinkedList<Integer> level = new LinkedList<>();
      for (int i = 0; i < lsize; i++) {
        TreeNode n = q.removeLast();
        if (!reverse) {
          level.addLast(n.val);
        } else {
          level.addFirst(n.val);
        }

        if (n.left != null) {
          q.addFirst(n.left);
        }
        if (n.right != null) {
          q.addFirst(n.right);
        }
      }
      reverse = !reverse;
      result.add(level);

    }
    return result;
  }

}
