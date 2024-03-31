package utils.graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Predicate;

class DfsTraverseLinear implements SimpleGraphTraverse {

  final static DfsTraverseLinear INSTANCE = new DfsTraverseLinear();

  private DfsTraverseLinear() {
  }

  @Override
  public <T> void traverse(SimpleGraph<T> graph, T startNode, Predicate<T> visitor) {
    Deque<T> stack = new LinkedList<>();
    stack.push(startNode);
    while (!stack.isEmpty()) {
      T node = stack.pop();
      if (visitor.test(node)) {
        for (T child : graph.childs(node)) {
          stack.push(child);
        }
      }
    }
  }
}
