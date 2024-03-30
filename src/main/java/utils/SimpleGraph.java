package utils;

import java.util.Collection;

public interface SimpleGraph<T> {
  Collection<T> childs(T node);

  boolean isTheSame(T node1, T node2);

  int size();
}
