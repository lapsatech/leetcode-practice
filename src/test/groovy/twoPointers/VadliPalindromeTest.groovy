package twoPointers

import spock.lang.Specification
import spock.lang.Unroll

class VadliPalindromeTest extends Specification {

  @Unroll
  def 'test'(def s, def expectedResult) {
    given:
    def subject = new VadliPalindrome();

    when:
    def res = subject.isPalindrome(s)

    then:
    res == expectedResult

    where:
    s                                | expectedResult
    'A man, a plan, a canal: Panama' | true
    'race a car'                     | false
    ' '                              | true
    '0P'                             | false
  }
}
