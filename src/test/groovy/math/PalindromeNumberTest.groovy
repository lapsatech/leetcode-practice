package math

import spock.lang.Specification
import spock.lang.Unroll

class PalindromeNumberTest extends Specification {

  @Unroll
  def 'test'(def x, def expectedResult) {
    given:
    def subject = new PalindromeNumber();

    when:
    def res = subject.isPalindrome(x)

    then:
    res == expectedResult

    where:
    x          | expectedResult
    655555556  | true
    2110000112 | true
    210000112  | false
  }
}
