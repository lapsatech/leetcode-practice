package graphGeneral;

import java.util.LinkedList;

import models.graph.Node;

public class CloneGraph {

  public Node cloneGraph(Node head) {
    if (head == null) {
      return null;
    }

    Node[] clones = new Node[101];
    clones[head.val] = new Node(head.val);

    LinkedList<Node> q = new LinkedList<>();
    q.add(head);

    while (!q.isEmpty()) {
      Node node = q.remove();
      Node clone = clones[node.val];
      for (Node neighbor : node.neighbors) {
        if (clones[neighbor.val] == null) {
          clones[neighbor.val] = new Node(neighbor.val);
          q.add(neighbor);
        }
        clone.neighbors.add(clones[neighbor.val]);
      }
    }

    return clones[head.val];
  }

}
