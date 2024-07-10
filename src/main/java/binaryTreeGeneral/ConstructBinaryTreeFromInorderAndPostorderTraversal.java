package binaryTreeGeneral;

import java.util.HashMap;
import java.util.Map;

import models.binaryTree.BinaryTreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

  public BinaryTreeNode buildTree(int[] inorder, int[] postorder) {
    Map<Integer, Integer> inorderIndex = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderIndex.put(inorder[i], i);
    }
    return splitAndBuild(
        inorderIndex,
        postorder,
        0,
        postorder.length - 1,
        0);
  }

  private BinaryTreeNode splitAndBuild(
      Map<Integer, Integer> inorderIndex,
      int[] postorder,
      int leftBoundary,
      int rightBoundary,
      int shift) {

    if (leftBoundary > rightBoundary || leftBoundary < 0 || rightBoundary >= postorder.length) {
      return null;
    }

    int val = postorder[rightBoundary];

    if (leftBoundary == rightBoundary) {
      return new BinaryTreeNode(val);
    }

    int index = inorderIndex.get(val).intValue();
    return new BinaryTreeNode(
        val,
        splitAndBuild(
            inorderIndex,
            postorder,
            leftBoundary,
            leftBoundary + index - shift - 1,
            shift),
        splitAndBuild(
            inorderIndex,
            postorder,
            leftBoundary + index - shift,
            rightBoundary - 1,
            index + 1));
  }
}
