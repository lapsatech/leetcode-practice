package metacarees

import spock.lang.Specification
import spock.lang.Unroll

class StackStabilizationTest extends Specification {

  @Unroll
  def 'test'(def N, def R, def expected) {
    given:
    def subject = new StackStabilization();

    when:
    def res = subject.getMinimumDeflatedDiscCount(N, R as int[])

    then:
    res == expected

    where:
    N | R                  | expected
    5 | [2, 5, 3, 6, 5]    | 3
    3 | [100, 100, 100]    | 2
    4 | [6, 5, 4, 3]       | -1
  }
}
