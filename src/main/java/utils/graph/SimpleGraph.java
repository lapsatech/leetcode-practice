package utils.graph;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

public interface SimpleGraph<T> {

  static <T> SimpleGraph<T> ofMap(Map<T, ? extends Collection<T>> index) {
    return new MapCollectionSimpleGraph<>(index);
  }

  static IntArraySimpleGraph ofIntArray(int[][] index) {
    return new IntArraySimpleGraph(index);
  }

  Collection<T> childs(T node);

  default boolean isTheSame(T node1, T node2) {
    return Objects.equals(node1, node2);
  }
}
