package arrayString

import spock.lang.Specification
import spock.lang.Unroll

class JumpGameIITest extends Specification {

  @Unroll
  def 'test #input #expect'(def input, def expect) {
    given:
    def s = new JumpGameII();

    when:
    def res = s.jump(input as int[])

    then:
    res == expect

    where:
    input               | expect
    []                  | -1
    [0]                 | 0
    [1, 2]              | 1
    [2, 3, 1, 1, 4]     | 2
    [2, 3, 0, 1, 4]     | 2
    [1, 2, 1, 1, 1]     | 3
    [1, 2, 3]           | 2
  }
}