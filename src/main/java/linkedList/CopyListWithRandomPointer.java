package linkedList;

import java.util.HashMap;
import java.util.Map;

import models.linkedlist.Node;

public class CopyListWithRandomPointer {

  public Node copyRandomList(final Node head) {

    final Node output = new Node(-1);

    Node copy = output;
    Node origin = head;

    Map<Node, Node> oldToNew = new HashMap<>();

    while (origin != null) {
      copy.next = oldToNew.computeIfAbsent(origin, c -> new Node(c.val));
      copy = copy.next;
      if (origin.random != null) {
        copy.random = oldToNew.computeIfAbsent(origin.random, c -> new Node(c.val));
      }

      origin = origin.next;
    }
    return output.next;
  }

}
