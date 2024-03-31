package utils.graph;

import java.util.HashSet;
import java.util.function.Predicate;

class DfsTraverseRecursive implements SimpleGraphTraverse {

  final static DfsTraverseRecursive INSTANCE = new DfsTraverseRecursive();

  private DfsTraverseRecursive() {
  }

  @Override
  public <T> void traverse(SimpleGraph<T> graph, T startNode, Predicate<T> visitor) {
    HashSet<T> visited = new HashSet<>();
    helper(graph, startNode, visited, visitor);
  }

  public <T> void helper(SimpleGraph<T> graph, T node, HashSet<T> visited, Predicate<T> visitor) {
    if (visitor.test(node)) {
      for (T child : graph.childs(node)) {
        if (visited.add(child)) {
          helper(graph, child, visited, visitor);
        }
      }
    }
  }
}
