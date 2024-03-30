package graphBFS;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SnakesAndLadders {

  public int snakesAndLadders(int[][] boustrophedonBoard) {
    FlattenBoard board = new BoustrophedonFlattenBoardView(boustrophedonBoard);
    SimpleGraph<Integer> graph = new SnakeAndLaddersGameGraph(board, 6);
    GraphMethods finder = new GraphMethodsImpl();
    return finder.leastSteps(graph, 0, board.length() - 1);
  }

  public static interface FlattenBoard {

    int length();

    int get(int index);
  }

  public static class BoustrophedonFlattenBoardView implements FlattenBoard {

    private final int[][] boustrophedonBoard;
    private final int length;
    private final int n;

    public BoustrophedonFlattenBoardView(int[][] boustrophedonBoard) {
      this.boustrophedonBoard = boustrophedonBoard;
      this.n = boustrophedonBoard.length;
      this.length = this.n * this.n;
    }

    @Override
    public int length() {
      return length;
    }

    @Override
    public int get(int index) {
      int y = index / n;
      int x = index % n;
      if (y % 2 == 1) {
        x = n - x - 1;
      }
      y = n - y - 1;
      return boustrophedonBoard[y][x];
    }

  }

  public static interface SimpleGraph<T> {
    Collection<T> childs(T node);

    boolean isTheSame(T node1, T node2);

    int size();
  }

  public static class SnakeAndLaddersGameGraph implements SimpleGraph<Integer> {

    private final FlattenBoard board;
    private final int diceSidesCount;

    public SnakeAndLaddersGameGraph(FlattenBoard board, int diceSidesCount) {
      this.board = board;
      this.diceSidesCount = diceSidesCount;
    }

    @Override
    public Collection<Integer> childs(Integer node) {
      Set<Integer> cc = new TreeSet<>();
      int i = node.intValue();
      int mmax = Math.min(board.length(), i + 1 + diceSidesCount);
      for (int x = i + 1; x < mmax; x++) {
        int v = board.get(x);
        if (v < 0) {
          cc.add(x);
        } else {
          if (v > board.length() || v < 1) {
            throw new IllegalArgumentException("Snake or ladder index is out of bounds " + v);
          }
          cc.add(v - 1);
        }
      }
      return cc;
    }

    @Override
    public int size() {
      return board.length();
    }

    @Override
    public boolean isTheSame(Integer node1, Integer node2) {
      return node1.intValue() == node2.intValue();
    }

  }

  public static interface GraphMethods {

    <T> int leastSteps(SimpleGraph<T> graph, T startNode, T finishNode);

    <T> List<T> shortestPath(SimpleGraph<T> graph, T startNode, T finishNode);
  }

  public static class GraphMethodsImpl implements GraphMethods {

    @Override
    public <T> int leastSteps(SimpleGraph<T> graph, T startNode, T finishNode) {
      HashSet<T> visited = new HashSet<>();
      LinkedList<T> queue = new LinkedList<>();
      queue.addLast(startNode);
      int level = 0;
      while (!queue.isEmpty()) {
        int sz = queue.size();
        for (int i = 0; i < sz; i++) {
          T node = queue.removeLast();
          if (graph.isTheSame(node, finishNode)) {
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

    private static class Qe<T> {
      final T node;
      final Qe<T> prev;

      private Qe(T node, Qe<T> prev) {
        this.node = node;
        this.prev = prev;
      }

      private Qe(T node) {
        this.node = node;
        this.prev = null;
      }
    }

    @Override
    public <T> List<T> shortestPath(SimpleGraph<T> graph, T startNode, T finishNode) {
      HashSet<T> visited = new HashSet<>();
      LinkedList<Qe<T>> queue = new LinkedList<>();
      queue.addLast(new Qe<>(startNode));
      while (!queue.isEmpty()) {
        int sz = queue.size();
        for (int i = 0; i < sz; i++) {
          final Qe<T> qe = queue.removeLast();
          if (graph.isTheSame(qe.node, finishNode)) {
            // path found generating vector
            LinkedList<T> result = new LinkedList<>();
            Qe<T> qee = qe;
            while (qee.prev != null) {
              result.addFirst(qee.node);
              qee = qee.prev;
            }
            result.addFirst(qee.node);
            return result;
          }
          for (T child : graph.childs(qe.node)) {
            if (visited.add(child)) {
              queue.addFirst(new Qe<>(child, qe));
            }
          }
        }
      }
      return null;
    }
  }

}
