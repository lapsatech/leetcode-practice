package models.binaryTree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NodeWithNextRightPointer extends Node<NodeWithNextRightPointer> {

  public static NodeWithNextRightPointer ofList(List<Integer> asList) {
    return ofList(asList, NodeWithNextRightPointer::new, NodeWithNextRightPointer[]::new);
  }

  public NodeWithNextRightPointer next;

  public NodeWithNextRightPointer() {
    super();
  }

  public NodeWithNextRightPointer(int val, NodeWithNextRightPointer left, NodeWithNextRightPointer right, NodeWithNextRightPointer next) {
    super(val, left, right);
    this.next = next;
  }

  public NodeWithNextRightPointer(int val) {
    super(val);
  }

  public static List<Integer> toNextList(final NodeWithNextRightPointer root) {
    if (root == null) {
      return Collections.emptyList();
    }

    LinkedList<Integer> res = new LinkedList<>();

    NodeWithNextRightPointer n = root;

    while (n != null) {
      res.add(n.val);
      NodeWithNextRightPointer nn = n.next;
      while (nn != null) {
        res.add(nn.val);
        nn = nn.next;
      }
      res.add(null);
      n = n.left != null ? n.left : n.right;
    }
    return res;
  }

}
