package utils.graph;

public interface IntArrayGraph extends Graph<Integer> {

  @Deprecated
  Iterable<Integer> childs(Integer node);

  int[] childsAsIntArray(int node);

}