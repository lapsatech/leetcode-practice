package binarySearchTree;

import java.util.function.Consumer;

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

    interface Traverse {
      void traverse(TreeNode node, Consumer<TreeNode> visitor);
    }

    class Inorder implements Traverse {

      @Override
      public void traverse(TreeNode node, Consumer<TreeNode> visitor) {

        if (node.left != null) {
          traverse(node.left, visitor);
        }

        visitor.accept(node);

        if (node.right != null) {
          traverse(node.right, visitor);
        }
      }

    }

    MinValueDifferenceFinderVisitor minFinder = new MinValueDifferenceFinderVisitor();
    Traverse traverse = new Inorder();
    traverse.traverse(root, minFinder::visit);
    return minFinder.min;
  }

}
