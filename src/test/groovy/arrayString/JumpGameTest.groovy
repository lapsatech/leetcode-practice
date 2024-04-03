package arrayString

import spock.lang.Specification
import spock.lang.Unroll

class JumpGameTest extends Specification {

  @Unroll
  def 'test'(def input, def expect) {
    given:
    def s = new JumpGame();

    when:
    def res = s.canJump(input as int[])

    then:
    res == expect

    where:
    input               | expect
    [2, 3, 1, 1, 4]     | true
    [3, 2, 1, 0, 4]     | false
    [0, 2, 3]           | false
    
  }
}