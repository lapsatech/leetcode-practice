package utils.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ShortestPath {

  private static class PathEntry<T> {
    final T node;
    final PathEntry<T> prev;

    private PathEntry(T node, PathEntry<T> prev) {
      this.node = node;
      this.prev = prev;
    }

    private PathEntry(T node) {
      this.node = node;
      this.prev = null;
    }
  }

  public <T> List<T> findPath(SimpleGraph<T> graph, T startNode, T finishNode) {
    final HashSet<T> visited = new HashSet<>();

    final LinkedList<PathEntry<T>> queue = new LinkedList<>();
    queue.addLast(new PathEntry<>(startNode));

    while (!queue.isEmpty()) {
      final int sz = queue.size();
      for (int i = 0; i < sz; i++) {
        final PathEntry<T> currentEntry = queue.removeLast();
        if (graph.isTheSame(currentEntry.node, finishNode)) {
          // path found generating vector
          LinkedList<T> result = new LinkedList<>();
          PathEntry<T> qee = currentEntry;
          while (qee.prev != null) {
            result.addFirst(qee.node);
            qee = qee.prev;
          }
          result.addFirst(qee.node);
          return result;
        }
        for (T child : graph.childs(currentEntry.node)) {
          if (visited.add(child)) {
            queue.addFirst(new PathEntry<>(child, currentEntry));
          }
        }
      }
    }
    return null;
  }
}
