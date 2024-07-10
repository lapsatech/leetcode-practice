package binaryTreeGeneral;

import java.util.LinkedList;

import models.binaryTree.NodeWithNextRightPointer;

public class PopulatingNextRightPointersInEachNodeII {

  public NodeWithNextRightPointer connect(NodeWithNextRightPointer root) {
    return bfs(root);
  }

  private NodeWithNextRightPointer bfs(NodeWithNextRightPointer root) {
    if (root == null) {
      return null;
    }

    LinkedList<NodeWithNextRightPointer> stack = new LinkedList<>();
    stack.addLast(root);

    while (!stack.isEmpty()) {
      int sz = stack.size();
      NodeWithNextRightPointer n = stack.removeLast();

      if (n.left != null) {
        stack.addFirst(n.left);
      }
      if (n.right != null) {
        stack.addFirst(n.right);
      }

      for (int i = 1; i < sz; i++) {
        NodeWithNextRightPointer nn = stack.removeLast();
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
