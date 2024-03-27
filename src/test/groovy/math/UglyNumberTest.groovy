package math

import spock.lang.Specification
import spock.lang.Unroll

class UglyNumberTest extends Specification {

  @Unroll
  def 'test'(def x, def expectedResult) {
    given:
    def subject = new UglyNumber();

    when:
    def res = subject.isUgly(x)

    then:
    res == expectedResult

    where:
    x          | expectedResult
    6          | true
    1          | true
    14         | false
  }
}
