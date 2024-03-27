package binaryTreeGeneral;

import java.util.HashMap;
import java.util.Map;

import models.binaryTree.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> inorderIndex = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderIndex.put(inorder[i], i);
    }
    return splitAndBuild(
        inorderIndex,
        preorder,
        0,
        preorder.length - 1,
        0);
  }

  private TreeNode splitAndBuild(
      Map<Integer, Integer> inorderIndex,
      int[] preorder,
      int leftBoundary,
      int rightBoundary,
      int shift) {

    if (leftBoundary > rightBoundary || leftBoundary < 0 || rightBoundary >= preorder.length) {
      return null;
    }

    int val = preorder[leftBoundary];

    if (leftBoundary == rightBoundary) {
      return new TreeNode(val);
    }

    int index = inorderIndex.get(val).intValue();
    return new TreeNode(
        val,
        splitAndBuild(
            inorderIndex,
            preorder,
            leftBoundary + 1,
            leftBoundary + index - shift,
            shift),
        splitAndBuild(inorderIndex,
            preorder,
            leftBoundary + index - shift + 1,
            rightBoundary,
            index + 1));
  }
}
