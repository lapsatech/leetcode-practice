package utils.graph;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntArrayGraphImpl implements IntArrayGraph {

  private final int[][] index;

  IntArrayGraphImpl(int[][] index) {
    this.index = index;
  }

  @Override
  public Iterable<Integer> childs(Integer node) {
    final int n = node.intValue();
    if (n < 0 || n >= index.length) {
      throw new IllegalArgumentException("Out of bounds");
    }
    int[] childs = index[n];

    if (childs != null) {
      if (childs.length > 1) {
        return IntStream.of(childs)
            .boxed()
            .collect(Collectors.toList());
      }
      if (childs.length == 1) {
        return Collections.singleton(childs[0]);
      }
    }
    return Collections.emptyList();
  }

  private static final int[] EMPTY = new int[] {};

  @Override
  public int[] childsAsIntArray(int node) {
    if (node < 0 || node > index.length) {
      throw new IllegalArgumentException("Out of bounds");
    }
    int[] result = index[node];
    if (result != null) {
      return result;
    }
    return EMPTY;
  }

}
