package utils.graph;

import java.util.HashSet;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class VisitOnceVisitor<T> implements Predicate<T> {
  private final HashSet<T> visited = new HashSet<>();
  private final Consumer<T> visitor;

  public VisitOnceVisitor(Consumer<T> visitor) {
    this.visitor = visitor;
  }

  public boolean visit(T t) {
    if (visited.add(t)) {
      visitor.accept(t);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean test(T t) {
    return visit(t);
  }

}
