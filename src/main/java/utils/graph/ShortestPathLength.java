package utils.graph;

import java.util.HashSet;
import java.util.LinkedList;

public class ShortestPathLength {

  public <T> int findLength(SimpleGraph<T> graph, T startNode, T finishNode) {
    final HashSet<T> visited = new HashSet<>();

    final LinkedList<T> queue = new LinkedList<>();
    queue.addLast(startNode);

    int level = 0;
    while (!queue.isEmpty()) {
      int sz = queue.size();
      for (int i = 0; i < sz; i++) {
        final T node = queue.removeLast();
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

}
