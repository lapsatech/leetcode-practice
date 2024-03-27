package models.binaryTree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Node extends ATreeNode<Node> {

  public static Node ofList(List<Integer> asList) {
    return ATreeNode.ofList(asList, Node::new, Node[]::new);
  }

  public Node next;

  public Node() {
    super();
  }

  public Node(int val, Node left, Node right, Node next) {
    super(val, left, right);
    this.next = next;
  }

  public Node(int val) {
    super(val);
  }

  public static List<Integer> toNextList(final Node root) {
    if (root == null) {
      return Collections.emptyList();
    }

    LinkedList<Integer> res = new LinkedList<>();

    Node n = root;

    while (n != null) {
      res.add(n.val);
      Node nn = n.next;
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
