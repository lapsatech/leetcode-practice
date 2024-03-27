package arrayString

import spock.lang.Specification
import spock.lang.Unroll

class RomanToIntegerTest extends Specification {

  @Unroll
  def 'test'(def roman, def expectedInt) {
    given:
    def subject = new RomanToInteger();

    when:
    def res = subject.romanToInt(roman)

    then:
    res == expectedInt

    where:
    roman     | expectedInt
    'III'     | 3
    'LVIII'   | 58
    'MCMXCIV' | 1994
  }
}
