package arrayString;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import arrayString.InsertDeleteGetRandomO1.RandomizedSet;

public class InsertDeleteGetRandomO1Test {

  final int getRandomTestRequestsCount = 1_000_000;
  final double randomValuesProbabilityTreshold = 0.05d;// shouldn't be greater than 10% appearance of the random value
                                                       // in comparison to average

  RandomizedSet subject = new RandomizedSet();

  @Test
  public void test() {

    Assertions.assertTrue(subject.insert(1));
    testGetRandomExpectOnly(1);

    Assertions.assertFalse(subject.insert(1));

    Assertions.assertTrue(subject.insert(10));
    testGetRandomExpectOnly(1, 10);

    Assertions.assertFalse(subject.insert(1));
    Assertions.assertFalse(subject.insert(10));

    Assertions.assertTrue(subject.insert(20));
    testGetRandomExpectOnly(1, 10, 20);

    Assertions.assertFalse(subject.insert(1));
    Assertions.assertFalse(subject.insert(10));
    Assertions.assertFalse(subject.insert(20));

    Assertions.assertTrue(subject.insert(30));
    testGetRandomExpectOnly(1, 10, 20, 30);

    Assertions.assertTrue(subject.remove(30));
    testGetRandomExpectOnly(1, 10, 20);
    Assertions.assertFalse(subject.remove(30));

    Assertions.assertTrue(subject.remove(1));
    testGetRandomExpectOnly(10, 20);
    Assertions.assertFalse(subject.remove(30));
    Assertions.assertFalse(subject.remove(1));

    Assertions.assertTrue(subject.remove(20));
    testGetRandomExpectOnly(10);
    Assertions.assertFalse(subject.remove(30));
    Assertions.assertFalse(subject.remove(1));
    Assertions.assertFalse(subject.remove(20));
  }

  private void testGetRandomExpectOnly(int... expectOnlyRandoms) {
    Map<Integer, Integer> stats = IntStream.range(0, getRandomTestRequestsCount)
        .map(c -> subject.getRandom())
        .boxed()
        .collect(Collectors.groupingBy(c -> c, Collectors.reducing(0, e -> 1, Integer::sum)));

    int sum = stats.values().stream().mapToInt(Integer::intValue).sum();

    Assertions.assertEquals(getRandomTestRequestsCount, sum);

    ArrayList<Integer> randomsSorted = new ArrayList<>(stats.keySet());
    randomsSorted.sort(Integer::compareTo);

    List<Integer> expectOnlyRandomsSorted = IntStream.of(expectOnlyRandoms)
        .boxed()
        .sorted()
        .collect(Collectors.toList());

    Assertions.assertIterableEquals(expectOnlyRandomsSorted, randomsSorted);

    final int avg = getRandomTestRequestsCount / stats.size();
    final double allowedDelta = avg * randomValuesProbabilityTreshold;
    stats.values().forEach(cnt -> Assertions.assertEquals(avg, cnt, allowedDelta));
  }

}
