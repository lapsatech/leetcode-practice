package utils.graph;

import java.util.Collections;
import java.util.Map;

class MapIterableGraph<T> implements Graph<T> {

  private final Map<T, ? extends Iterable<T>> index;

  MapIterableGraph(Map<T, ? extends Iterable<T>> index) {
    this.index = index;
  }

  @Override
  public Iterable<T> childs(T node) {
    Iterable<T> c = index.get(node);
    if (c != null) {
      return c;
    }
    return Collections.emptySet();
  }
}
