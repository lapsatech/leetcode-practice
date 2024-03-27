package stack

import spock.lang.Specification
import spock.lang.Unroll

class ValidParenthesesTest extends Specification {

  @Unroll
  def 'test'(def s, def expectedResult) {
    given:
    def subject = new ValidParentheses();

    when:
    def res = subject.isValid(s)

    then:
    res == expectedResult

    where:
    s              | expectedResult
    '['            | false
    '()'           | true
    '([]{})'       | true
    '[]{}()'       | true
    '([{[})'       | false
    '[[[[[[]]]]]]' | true
  }
}