package arrayString

import spock.lang.Specification
import spock.lang.Unroll

class LengthOfLastWordTest extends Specification {

  @Unroll
  def 'test'(def input, def expect) {
    given:
    def s = new LengthOfLastWord()

    when:
    def res = s.lengthOfLastWord(input) as int

    then:
    res == expect

    where:
    input                 | expect
    'Hello World'         | 5
    '   fly me   to   the moon  ' | 4
    'luffy is still joyboy' | 6
  }
}
