package binaryTreeBFS;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import models.binaryTree.TreeNode;

public class BinaryTreeLevelOrderTraversal {

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new LinkedList<>();

    LinkedList<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
      int lsize = q.size();
      LinkedList<Integer> level = new LinkedList<>();
      for (int i = 0; i < lsize; i++) {
        TreeNode n = q.removeLast();
        level.add(n.val);

        if (n.left != null) {
          q.addFirst(n.left);
        }
        if (n.right != null) {
          q.addFirst(n.right);
        }
      }
      result.add(level);

    }
    return result;
  }

}
