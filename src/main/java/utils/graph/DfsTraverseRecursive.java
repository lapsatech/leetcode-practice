package utils.graph;

import java.util.function.Predicate;

class DfsTraverseRecursive implements SimpleGraphTraverse {

  final static DfsTraverseRecursive INSTANCE = new DfsTraverseRecursive();

  private DfsTraverseRecursive() {
  }

  @Override
  public <T> void traverse(SimpleGraph<T> graph, T startNode, Predicate<T> visitor) {
    if (visitor.test(startNode)) {
      helper(graph, startNode, visitor);
    }
  }

  public <T> void helper(SimpleGraph<T> graph, T node, Predicate<T> visitor) {
    for (T child : graph.childs(node)) {
      if (visitor.test(child)) {
        helper(graph, child, visitor);
      }
    }
  }
}
