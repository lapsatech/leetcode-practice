package binarySearchTree;

import java.util.function.Consumer;

import models.binaryTree.TreeNode;

public class RecursiveInorder implements Traverse {

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
