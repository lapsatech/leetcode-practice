package models.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class Node {

  public int val;
  public Node next;
  public Node random;

  public Node(int val) {
    this.val = val;
  }

  public static Node fromList(List<List<Integer>> listDef) {

    final Node output = new Node(-1);
    Node current = output;

    List<Node> nodes = new ArrayList<>();

    for (List<Integer> nodeDef : listDef) {
      current.next = new Node(nodeDef.get(0));
      nodes.add(current.next);
      current = current.next;
    }

    for (int i = 0; i < nodes.size(); i++) {
      Integer randomIndex = listDef.get(i).get(1);
      if (randomIndex != null) {
        nodes.get(i).random = nodes.get(randomIndex);
      }
    }

    return output.next;
  }

  public static List<List<Integer>> toList(final Node head) {

    List<Node> nodes = new ArrayList<>();

    Node current = head;
    while (current != null) {
      nodes.add(current);
      current = current.next;
    }

    List<List<Integer>> result = new ArrayList<>();

    for (Node node : nodes) {
      List<Integer> n = new ArrayList<>();
      result.add(n);

      n.add(node.val);
      if (node.random == null) {
        n.add(null);
      } else {
        Integer randomIndex = nodes.indexOf(node.random);
        n.add(randomIndex);
      }

    }

    return result;
  }

  @Override
  public String toString() {
    return String.valueOf(toList(this));
  }
}