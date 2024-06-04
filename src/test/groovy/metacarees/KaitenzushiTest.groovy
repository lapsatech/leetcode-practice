package metacarees

import spock.lang.Specification
import spock.lang.Unroll

class KaitenzushiTest extends Specification {

  @Unroll
  def 'test'(def N, def D, def K, def expected) {
    given:
    def subject = new Kaitenzushi();

    when:
    def res = subject.getMaximumEatenDishCount(N, D as int[], K)

    then:
    res == expected

    where:
    N | D                     | K | expected
    6 | [1, 2, 3, 3, 2, 1]    | 1 | 5
    6 | [1, 2, 3, 3, 2, 1]    | 2 | 4
    7 | [1, 2, 1, 2, 1, 2, 1] | 2 | 2
  }
}
