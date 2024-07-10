package binaryTreeGeneral;

import models.binaryTree.BinaryTreeNode;

public class CountCompleteTreeNodes {

  private int leftHeight(BinaryTreeNode root) {
    BinaryTreeNode temp;

    temp = root;
    int height = 0;
    while (temp != null) {
      height++;
      temp = temp.left;
    }
    return height;
  }

  private int rightHeight(BinaryTreeNode root) {
    BinaryTreeNode temp;

    temp = root;
    int height = 0;
    while (temp != null) {
      height++;
      temp = temp.right;
    }
    return height;
  }

  public int countNodes(BinaryTreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }

    int lh = leftHeight(root);
    int rh = rightHeight(root);

    if (lh == rh) {
      // it's perfect
      int c = ((int) Math.pow(2, lh)) - 1;
      return c;
    }

    int cntLeft = countNodes(root.left);
    int cntRight = countNodes(root.right);
    return 1 + cntLeft + cntRight;
  }

}
