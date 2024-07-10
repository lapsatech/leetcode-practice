package binaryTreeGeneral;

import java.util.HashMap;
import java.util.Map;

import models.binaryTree.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

  public TreeNode buildTree(int[] inorder, int[] postorder) {
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

  private TreeNode splitAndBuild(
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
      return new TreeNode(val);
    }

    int index = inorderIndex.get(val).intValue();
    return new TreeNode(
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
