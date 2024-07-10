package binaryTreeGeneral;

import java.util.LinkedList;
import java.util.Queue;

import models.binaryTree.BinaryTreeNode;

public class MaximumDepthOfBinaryTree {

  public int maxDepth(BinaryTreeNode root) {
     return maxDepthVisitor(root);
  }

  public int maxDepthRecurrent(BinaryTreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepthRecurrent(root.left), maxDepthRecurrent(root.right));
  }

  public int maxDepthVisitor(BinaryTreeNode root) {
    if (root == null) {
      return 0;
    }

    int height = 0;
    Queue<BinaryTreeNode> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
      height++;

      int size = q.size();

      for (int i = 0; i < size; i++) {
        BinaryTreeNode temp = q.remove();

        if (temp.left != null) {
          q.add(temp.left);
        }
        if (temp.right != null) {
          q.add(temp.right);
        }
      }
    }
    return height;
  }

}
