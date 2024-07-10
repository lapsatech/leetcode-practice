package utils.graph;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public final class Graphs {

  private Graphs() {
  }

  public static <T> Graph<T> ofMap(Map<T, ? extends Iterable<T>> index) {
    return new MapIterableGraph<>(index);
  }

  public static IntArrayGraph ofIntArray(int[][] index) {
    return new IntArrayGraphImpl(index);
  }

  public static <T> void bfsTraverse(Graph<T> graph, T startNode, Consumer<T> visitor) {
    bfsTraverse(graph, startNode, new VisitOnceVisitor<>(visitor));
  }

  public static <T> void bfsTraverse(Graph<T> graph, T startNode, Predicate<T> visitor) {
    Deque<T> fifo = new LinkedList<>();
    fifo.add(startNode);
    while (!fifo.isEmpty()) {
      int size = fifo.size();
      for (int i = 0; i < size; i++) {
        T node = fifo.remove();
        if (visitor.test(node)) {
          for (T child : graph.childs(node)) {
            fifo.add(child);
          }
        }
      }
    }
  }

  public static <T> void dfsTraverse(Graph<T> graph, T startNode, Consumer<T> visitor) {
    dfsTraverse(graph, startNode, new VisitOnceVisitor<>(visitor));
  }

  public static <T> void dfsTraverse(Graph<T> graph, T startNode, Predicate<T> visitor) {
    Deque<T> stack = new LinkedList<>();
    stack.push(startNode);
    while (!stack.isEmpty()) {
      T node = stack.pop();
      if (visitor.test(node)) {
        for (T child : graph.childs(node)) {
          stack.push(child);
        }
      }
    }
  }

  public static <T> void dfsRecursiveTraverse(Graph<T> graph, T startNode, Consumer<T> visitor) {
    dfsRecursiveTraverse(graph, startNode, new VisitOnceVisitor<>(visitor));
  }

  public static <T> void dfsRecursiveTraverse(Graph<T> graph, T startNode, Predicate<T> visitor) {
    if (visitor.test(startNode)) {
      dfsRecursiveHelper(graph, startNode, visitor);
    }
  }

  private static <T> void dfsRecursiveHelper(Graph<T> graph, T node, Predicate<T> visitor) {
    for (T child : graph.childs(node)) {
      if (visitor.test(child)) {
        dfsRecursiveHelper(graph, child, visitor);
      }
    }
  }

  public static <T> int shortestPathLength(Graph<T> graph, T startNode, T finishNode) {

    final HashSet<T> visited = new HashSet<>();
    final Deque<T> fifo = new LinkedList<>();
    fifo.addLast(startNode);
    int level = 0;
    while (!fifo.isEmpty()) {
      int sz = fifo.size();
      for (int i = 0; i < sz; i++) {
        final T node = fifo.removeLast();
        if (graph.isTheSame(node, finishNode)) {
          return level;
        }
        for (T child : graph.childs(node)) {
          if (visited.add(child)) {
            fifo.addFirst(child);
          }
        }
      }
      level++;
    }
    return -1;
  }

  public static <T> List<T> shortestPath(Graph<T> graph, T startNode, T finishNode) {
    final HashSet<T> visited = new HashSet<>();

    class PE {
      final T node;
      final PE prev;

      private PE(T node, PE prev) {
        this.node = node;
        this.prev = prev;
      }

      private PE(T node) {
        this.node = node;
        this.prev = null;
      }
    }

    final LinkedList<PE> queue = new LinkedList<>();
    queue.addLast(new PE(startNode));

    while (!queue.isEmpty()) {
      final int sz = queue.size();
      for (int i = 0; i < sz; i++) {
        final PE currentEntry = queue.removeLast();
        if (graph.isTheSame(currentEntry.node, finishNode)) {
          // path found generating vector
          LinkedList<T> result = new LinkedList<>();
          PE pe = currentEntry;
          while (pe.prev != null) {
            result.addFirst(pe.node);
            pe = pe.prev;
          }
          result.addFirst(pe.node);
          return result;
        }
        for (T child : graph.childs(currentEntry.node)) {
          if (visited.add(child)) {
            queue.addFirst(new PE(child, currentEntry));
          }
        }
      }
    }
    return null;
  }
}
