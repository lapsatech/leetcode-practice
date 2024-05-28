package arrayString

import spock.lang.Specification
import spock.lang.Unroll

class ReverseWordsInAStringTest extends Specification {

  @Unroll
  def 'test'(def input, def expect) {
    given:
    def subject = new ReverseWordsInAString();

    when:
    def res = subject.reverseWords(input)

    then:
    res == expect

    where:
    input     | expect
    'the sky is blue'     | 'blue is sky the'
    '  hello world  '   | 'world hello'
    'a good   example' | 'example good a'
  }
}
