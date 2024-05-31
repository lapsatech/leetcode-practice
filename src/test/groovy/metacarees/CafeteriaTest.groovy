package metacarees

import metacarees.Cafeteria
import spock.lang.Specification
import spock.lang.Unroll

class CafeteriaTest extends Specification {

  @Unroll
  def 'test'(long N, long K, int M, long[] S, def expected) {
    given:
    def subject = new Cafeteria();

    when:
    def res = subject.getMaxAdditionalDinersCount(N, K, M, S)

    then:
    res == expected

    where:
    N  | K | M | S           | expected
    10 | 1 | 2 | [2, 6]      | 3
    15 | 2 | 3 | [11, 6, 14] | 1
  }
}
