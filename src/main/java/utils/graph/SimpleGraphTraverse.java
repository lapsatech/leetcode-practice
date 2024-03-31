package utils.graph;

import java.util.function.Consumer;
import java.util.function.Predicate;

public interface SimpleGraphTraverse {

  static SimpleGraphTraverse bfs() {
    return BfsTraverse.INSTANCE;
  }

  static SimpleGraphTraverse dfsRecursive() {
    return DfsTraverseRecursive.INSTANCE;
  }

  static SimpleGraphTraverse dfsLinear() {
    return DfsTraverseLinear.INSTANCE;
  }

  <T> void traverse(SimpleGraph<T> graph, T startNode, Predicate<T> visitor);

  default <T> void traverse(SimpleGraph<T> graph, T startNode, Consumer<T> visitor) {
    traverse(graph, startNode, new VisitOnceVisitor<>(visitor));
  }

}
