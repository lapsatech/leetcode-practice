package binarySearchTree;

import java.util.function.Consumer;

import models.binaryTree.TreeNode;

public interface Traverse {
  void traverse(TreeNode node, Consumer<TreeNode> visitor);
}
