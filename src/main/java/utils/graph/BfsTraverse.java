package utils.graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Predicate;

class BfsTraverse implements SimpleGraphTraverse {

  final static BfsTraverse INSTANCE = new BfsTraverse();

  private BfsTraverse() {
  }

  @Override
  public <T> void traverse(SimpleGraph<T> graph, T startNode, Predicate<T> visitor) {
    Deque<T> queue = new LinkedList<>();
    queue.add(startNode);
    while (!queue.isEmpty()) {
      int sz = queue.size();
      for (int i = 0; i < sz; i++) {
        T node = queue.remove();
        if (visitor.test(node)) {
          for (T child : graph.childs(node)) {
            queue.add(child);
          }
        }
      }
    }
  }
}
