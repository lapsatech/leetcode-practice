package utils.graph;

import java.util.Objects;

public interface Graph<T> {

  Iterable<T> childs(T node);

  default boolean isTheSame(T node1, T node2) {
    return Objects.equals(node1, node2);
  }
}
