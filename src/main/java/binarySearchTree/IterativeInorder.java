package binarySearchTree;

import java.util.LinkedList;
import java.util.function.Consumer;

import models.binaryTree.TreeNode;

public class IterativeInorder implements Traverse {

  @Override
  public void traverse(TreeNode node, Consumer<TreeNode> visitor) {

    LinkedList<TreeNode> stack = new LinkedList<>();

    while (!stack.isEmpty() || node != null) {
      if (node != null) {
        stack.addLast(node);
        node = node.left;
      } else {
        node = stack.removeLast();
        visitor.accept(node);
        node = node.right;
      }
    }
  }

} 