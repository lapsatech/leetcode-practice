package arrayString

import spock.lang.Specification
import spock.lang.Unroll

class HIndexTest extends Specification {

  @Unroll
  def 'test'(def input, def expect) {
    given:
    def s = new HIndex();

    when:
    def res = s.hIndex(input as int[]) as int

    then:
    res == expect

    where:
    input                 | expect
    [3, 0, 6, 1, 5]       | 3
    [1, 3, 1]             | 1
    [1, 2]                | 1
    [0, 1]                | 1
    [0]                   | 0
    [1]                   | 1
  }
}