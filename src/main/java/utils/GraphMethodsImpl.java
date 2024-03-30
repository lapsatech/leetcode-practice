package utils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


public class GraphMethodsImpl implements GraphMethods {

  @Override
  public <T> int leastSteps(SimpleGraph<T> graph, T startNode, T finishNode) {
    HashSet<T> visited = new HashSet<>();
    LinkedList<T> queue = new LinkedList<>();
    queue.addLast(startNode);
    int level = 0;
    while (!queue.isEmpty()) {
      int sz = queue.size();
      for (int i = 0; i < sz; i++) {
        T node = queue.removeLast();
        if (graph.isTheSame(node, finishNode)) {
          return level;
        }
        for (T child : graph.childs(node)) {
          if (visited.add(child)) {
            queue.addFirst(child);
          }
        }
      }
      level++;
    }
    return -1;
  }

  private static class Qe<T> {
    final T node;
    final Qe<T> prev;

    private Qe(T node, Qe<T> prev) {
      this.node = node;
      this.prev = prev;
    }

    private Qe(T node) {
      this.node = node;
      this.prev = null;
    }
  }

  @Override
  public <T> List<T> shortestPath(SimpleGraph<T> graph, T startNode, T finishNode) {
    HashSet<T> visited = new HashSet<>();
    LinkedList<Qe<T>> queue = new LinkedList<>();
    queue.addLast(new Qe<>(startNode));
    while (!queue.isEmpty()) {
      int sz = queue.size();
      for (int i = 0; i < sz; i++) {
        final Qe<T> qe = queue.removeLast();
        if (graph.isTheSame(qe.node, finishNode)) {
          // path found generating vector
          LinkedList<T> result = new LinkedList<>();
          Qe<T> qee = qe;
          while (qee.prev != null) {
            result.addFirst(qee.node);
            qee = qee.prev;
          }
          result.addFirst(qee.node);
          return result;
        }
        for (T child : graph.childs(qe.node)) {
          if (visited.add(child)) {
            queue.addFirst(new Qe<>(child, qe));
          }
        }
      }
    }
    return null;
  }
}
