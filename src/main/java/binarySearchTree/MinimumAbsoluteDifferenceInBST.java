package binarySearchTree;

import models.binaryTree.TreeNode;

public class MinimumAbsoluteDifferenceInBST {

  public int getMinimumDifference(TreeNode root) {

    class MinValueDifferenceFinderVisitor {
      int min = Integer.MAX_VALUE;
      TreeNode prev = null;

      void visit(TreeNode node) {
        if (prev == null) {
          prev = node;
        } else {
          int dif = node.val - prev.val;
          min = Math.min(dif, min);
          prev = node;
        }
      }
    }

    MinValueDifferenceFinderVisitor minFinder = new MinValueDifferenceFinderVisitor();
    Traverse traverse = new RecursiveInorder();
    traverse.traverse(root, minFinder::visit);
    return minFinder.min;
  }

}
