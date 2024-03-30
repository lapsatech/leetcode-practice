package graphBFS;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import utils.GraphMethods;
import utils.GraphMethodsImpl;
import utils.SimpleGraph;

public class SnakesAndLadders {

  public int snakesAndLadders(int[][] boustrophedonBoard) {
    FlattenBoard board = new BoustrophedonFlattenBoardView(boustrophedonBoard);
    SimpleGraph<Integer> graph = new SnakeAndLaddersGameGraph(board, 6);
    GraphMethods finder = new GraphMethodsImpl();
    return finder.leastSteps(graph, 0, board.length() - 1);
  }

  private static interface FlattenBoard {

    int length();

    int get(int index);
  }

  private static class BoustrophedonFlattenBoardView implements FlattenBoard {

    private final int[][] boustrophedonBoard;
    private final int length;
    private final int n;

    private BoustrophedonFlattenBoardView(int[][] boustrophedonBoard) {
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

  private static class SnakeAndLaddersGameGraph implements SimpleGraph<Integer> {

    private final FlattenBoard board;
    private final int diceSidesCount;

    private SnakeAndLaddersGameGraph(FlattenBoard board, int diceSidesCount) {
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
}
