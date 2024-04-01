package arrayString

import spock.lang.Specification
import spock.lang.Unroll

class MajorityElementTest extends Specification {

  @Unroll
  def 'test'(def input, def expect) {
    given:
    def s = new MajorityElement()

    when:
    def res = s.majorityElement(input as int[]) as int

    then:
    res == expect

    where:
    input                 | expect
    [3, 2, 3]             | 3
    [2, 2, 1, 1, 1, 2, 2] | 2
    [3, 3, 4]             | 3
  }
}