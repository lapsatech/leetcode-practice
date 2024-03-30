package graphBFS;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SnakesAndLadders {

  static interface FlattenBoardBuilder {
    FlattenBoard fromBoustrophedon(int[][] boustrophedonBoard);
  }

  static class FlattenBoardBuilderImpl implements FlattenBoardBuilder {

    @Override
    public FlattenBoard fromBoustrophedon(int[][] boustrophedonBoard) {
      int n = boustrophedonBoard.length;
      int max = n * n;
      int[] straight = new int[max];

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          straight[i * n + j] = boustrophedonBoard[n - i - 1][i % 2 == 0 ? j : (n - j - 1)];
        }
      }

      return new LinearBoardImpl(straight);
    }

  }

  static interface FlattenBoard {

    int length();

    int get(int i);

    int[] asArray();

  }

  static class LinearBoardImpl implements FlattenBoard {

    private final int[] straight;

    LinearBoardImpl(int[] straight) {
      this.straight = straight;
    }

    @Override
    public int length() {
      return straight.length;
    }

    @Override
    public int get(int i) {
      return straight[i];
    }

    @Override
    public int[] asArray() {
      return straight;
    }
  }

  static interface Graph<T> {
    Collection<T> childs(T node);
  }

  static class MapSetGraph<T> implements Graph<T> {

    private final Map<T, Set<T>> index;

    MapSetGraph(Map<T, Set<T>> index) {
      this.index = index;
    }

    private final Set<T> empty = Collections.emptySet();

    @Override
    public Collection<T> childs(T node) {
      return index.getOrDefault(node, empty);
    }
  }

  static interface SnakeAndLaddersGraphBuilder {

    default Graph<Integer> build(FlattenBoard board) {
      return build(board, 6);
    }

    Graph<Integer> build(FlattenBoard board, int diceSidesCount);
  }

  static class AllPossibleTurnsSnakeAndLaddersGraphBuilder implements SnakeAndLaddersGraphBuilder {

    @Override
    public Graph<Integer> build(FlattenBoard board, int diceSidesCount) {
      int[] bb = board.asArray();
      Map<Integer, Set<Integer>> index = new TreeMap<>();
      for (int i = 0; i < bb.length; i++) {
        Set<Integer> cc = index.computeIfAbsent(i, c -> new TreeSet<>());
        int mmax = Math.min(bb.length, i + 1 + diceSidesCount);
        for (int x = i + 1; x < mmax; x++) {
          int v = bb[x];
          if (v < 0) {
            cc.add(x);
          } else {
            if (v > board.length() || v < 1) {
              throw new IllegalArgumentException("Snake or ladder index is out of bounds " + v);
            }
            cc.add(v - 1);
          }
        }

      }
      return new MapSetGraph<>(index);
    }
  }

  static interface ShortestPathFinder {
    <T> int findShortestPath(Graph<T> graph, T startNode, T finishNode);
  }

  static class BfsShortestPathFinder implements ShortestPathFinder {

    @Override
    public <T> int findShortestPath(Graph<T> graph, T startNode, T finishNode) {
      HashSet<T> visited = new HashSet<>();
      LinkedList<T> queue = new LinkedList<>();
      queue.addLast(startNode);
      int level = 0;
      while (!queue.isEmpty()) {
        int sz = queue.size();
        for (int i = 0; i < sz; i++) {
          T node = queue.removeLast();
          if (node.equals(finishNode)) {
            return level;
          }
          for (T child : graph.childs(node)) {
            if (visited.add(child)) {
              queue.addFirst(child);
            }
          }
        }
        level++;
      }
      return -1;
    }
  }

  public int snakesAndLadders(int[][] boustrophedonBoard) {
    FlattenBoardBuilder boardBuilder = new FlattenBoardBuilderImpl();
    FlattenBoard board = boardBuilder.fromBoustrophedon(boustrophedonBoard);

    SnakeAndLaddersGraphBuilder graphBuilder = new AllPossibleTurnsSnakeAndLaddersGraphBuilder();
    Graph<Integer> graph = graphBuilder.build(board);

    ShortestPathFinder finder = new BfsShortestPathFinder();
    return finder.findShortestPath(graph, 0, board.length() - 1);
  }
}
