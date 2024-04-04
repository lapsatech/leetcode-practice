package arrayString;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import arrayString.InsertDeleteGetRandomO1.RandomizedSet;

public class InsertDeleteGetRandomO1Test {

  RandomizedSet subject = new RandomizedSet();

  @Test
  public void test() {

    final double randomValuesProbabilityTreshold = 0.05d;// shouldn't be greater than 10% appearance of the random value
                                                         // in comparison to average
    final int getRandomTestRequestsCount = 1_000_000;

    Assertions.assertTrue(subject.insert(1));
    testGetRandom(subject, getRandomTestRequestsCount, randomValuesProbabilityTreshold, asList(1));

    Assertions.assertFalse(subject.insert(1));

    Assertions.assertTrue(subject.insert(10));
    testGetRandom(subject, getRandomTestRequestsCount, randomValuesProbabilityTreshold, asList(1, 10));

    Assertions.assertFalse(subject.insert(1));
    Assertions.assertFalse(subject.insert(10));

    Assertions.assertTrue(subject.insert(20));
    testGetRandom(subject, getRandomTestRequestsCount, randomValuesProbabilityTreshold, asList(1, 10, 20));

    Assertions.assertFalse(subject.insert(1));
    Assertions.assertFalse(subject.insert(10));
    Assertions.assertFalse(subject.insert(20));

    Assertions.assertTrue(subject.insert(30));
    testGetRandom(subject, getRandomTestRequestsCount, randomValuesProbabilityTreshold, asList(1, 10, 20, 30));

    Assertions.assertTrue(subject.remove(30));
    testGetRandom(subject, getRandomTestRequestsCount, randomValuesProbabilityTreshold, asList(1, 10, 20));
    Assertions.assertFalse(subject.remove(30));

    Assertions.assertTrue(subject.remove(1));
    testGetRandom(subject, getRandomTestRequestsCount, randomValuesProbabilityTreshold, asList(10, 20));
    Assertions.assertFalse(subject.remove(30));
    Assertions.assertFalse(subject.remove(1));

    Assertions.assertTrue(subject.remove(20));
    testGetRandom(subject, getRandomTestRequestsCount, randomValuesProbabilityTreshold, asList(10));
    Assertions.assertFalse(subject.remove(30));
    Assertions.assertFalse(subject.remove(1));
    Assertions.assertFalse(subject.remove(20));
  }

  private static void testGetRandom(
      final RandomizedSet set,
      final int count,
      final double thresholdRatio,
      Collection<Integer> expectOnlyRandomsSorted) {
    Map<Integer, Integer> stats = IntStream.range(0, count)
        .map(c -> set.getRandom())
        .boxed()
        .collect(Collectors.groupingBy(c -> c, Collectors.reducing(0, e -> 1, Integer::sum)));

    int sum = stats.values().stream().mapToInt(Integer::intValue).sum();

    Assertions.assertEquals(count, sum);

    ArrayList<Integer> randoms = new ArrayList<>(stats.keySet());
    randoms.sort(Integer::compareTo);

    Assertions.assertIterableEquals(expectOnlyRandomsSorted, randoms);

    final int avg = count / stats.size();
    final double allowedDelta = avg * thresholdRatio;
    stats.values().forEach(cnt -> Assertions.assertEquals(avg, cnt, allowedDelta));
  }

}
