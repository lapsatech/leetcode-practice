package models.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Node {

  public static Node fromAdjacencyList(List<List<Integer>> adjacencyList) {
    if (adjacencyList.isEmpty()) {
      return null;
    }
    Node[] index = new Node[adjacencyList.size()];
    for (int i = 0; i < index.length; i++) {
      index[i] = new Node(i + 1);
    }
    for (int i = 0; i < index.length; i++) {
      for (int childIdx : adjacencyList.get(i)) {
        index[i].neighbors.add(index[childIdx - 1]);
      }
    }
    return index[0];
  }

  public static List<List<Integer>> toAdjacencyList(Node head) {
    if (head == null) {
      return Collections.emptyList();
    }

    Map<Node, Integer> index = new HashMap<>();

    LinkedList<Node> q = new LinkedList<>();
    q.addLast(head);
    while (!q.isEmpty()) {
      Node n = q.removeLast();
      index.put(n, n.val - 1);
      for (Node nn : n.neighbors) {
        if (!index.containsKey(nn)) {
          q.addLast(nn);
        }
      }
    }

    return index.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue())
        .map(Map.Entry::getKey)
        .map(n -> n.neighbors
            .stream()
            .map(nn -> index.get(nn) + 1)
            .collect(Collectors.toList()))
        .collect(Collectors.toList());
  }

  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }

  @Override
  public String toString() {
    return String.valueOf(val);
  }

}
