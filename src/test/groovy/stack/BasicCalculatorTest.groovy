package stack

import spock.lang.Specification
import spock.lang.Unroll

class BasicCalculatorTest extends Specification {

  @Unroll
  def 'test'(def s, def expectedResult) {
    given:
    def subject = new BasicCalculator();

    when:
    def res = subject.calculate(s)

    then:
    res == expectedResult

    where:
    s                        | expectedResult
    '10 + 20 - (10+10)'      | 10
    '1+1'                    | 2
    '2-1+2'                  | 3
    '(1+(4+5+2)-3)+(6+8)'    | 23
    '1-(    -2)'             | 3
    '1--1'                   | 2
  }
}
