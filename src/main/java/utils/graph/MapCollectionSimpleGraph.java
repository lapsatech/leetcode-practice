package utils.graph;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

class MapCollectionSimpleGraph<T> implements SimpleGraph<T> {

  private final Map<T, ? extends Collection<T>> index;

  MapCollectionSimpleGraph(Map<T, ? extends Collection<T>> index) {
    this.index = index;
  }

  @Override
  public Collection<T> childs(T node) {
    Collection<T> c = index.get(node);
    if (c != null) {
      return c;
    }
    return Collections.emptySet();
  }
}
