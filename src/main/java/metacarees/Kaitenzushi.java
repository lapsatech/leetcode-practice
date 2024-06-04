package metacarees;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Kaitenzushi {

  public int getMaximumEatenDishCount(int N, int[] D, int K) {
    SizeLimitIndexedDeque<Integer> queue = new SizeLimitIndexedDeque<>(K);
    int counter = 0;
    for (int i = 0; i < N; i++) {
      if (queue.accept(D[i])) {
        counter++;
      }
    }
    return counter;
  }

}

class SizeLimitIndexedDeque<T> {
  private final Map<T, Integer> viewAsMap = new HashMap<>();
  private final Deque<T> viewAsQueue = new LinkedList<>();
  private final int maxSize;

  SizeLimitIndexedDeque(int maxSize) {
    this.maxSize = maxSize;
  }

  boolean accept(T v) {
    if (viewAsMap.containsKey(v)) {
      return false;
    }

    viewAsMap.compute(v, (e, count) -> {
      if (count == null) {
        return 1;
      } else {
        return count + 1;
      }
    });

    viewAsQueue.addLast(v);

    if (viewAsQueue.size() > maxSize) {
      T remove = viewAsQueue.removeFirst();
      viewAsMap.compute(remove, (e, count) -> {
        if (count == 1) {
          return null;
        } else {
          return count - 1;
        }
      });
    }
    return true;
  }
}
