package binaryTreeGeneral;

import java.util.LinkedList;

import models.binaryTree.Node;

public class PopulatingNextRightPointersInEachNodeII {

  public Node connect(Node root) {
    return bfs(root);
  }

  private Node bfs(Node root) {
    if (root == null) {
      return null;
    }

    LinkedList<Node> stack = new LinkedList<>();
    stack.addLast(root);

    while (!stack.isEmpty()) {
      int sz = stack.size();
      Node n = stack.removeLast();

      if (n.left != null) {
        stack.addFirst(n.left);
      }
      if (n.right != null) {
        stack.addFirst(n.right);
      }

      for (int i = 1; i < sz; i++) {
        Node nn = stack.removeLast();
        if (nn.left != null) {
          stack.addFirst(nn.left);
        }
        if (nn.right != null) {
          stack.addFirst(nn.right);
        }
        n.next = nn;
        n = nn;
      }
    }
    return root;
  }

}
