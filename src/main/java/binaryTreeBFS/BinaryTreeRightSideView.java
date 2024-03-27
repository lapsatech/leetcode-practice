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
    LinkedList<TreeNode> q = new LinkedList<>();

    q.add(root);

    while (!q.isEmpty()) {
      int lcount = q.size();

      TreeNode mostRight = null;
      for (int i = 0; i < lcount; i++) {
        TreeNode t = q.removeLast();
        if (mostRight == null) {
          mostRight = t;
        }

        if (t.right != null) {
          q.addFirst(t.right);
        }
        if (t.left != null) {
          q.addFirst(t.left);
        }
      }
      result.add(mostRight.val);
    }

    return result;
  }

}
