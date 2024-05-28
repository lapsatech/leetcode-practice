package arrayString

import spock.lang.Specification
import spock.lang.Unroll

class IntegerToRomanTest extends Specification {

  @Unroll
  def 'test'(def exepectedRoman, def integer) {
    given:
    def subject = new IntegerToRoman();

    when:
    def res1 = subject.intToRoman1(integer)

    then:
    res1 == exepectedRoman

    when:
    def res2 = subject.intToRoman2(integer)

    then:
    res2 == exepectedRoman

    where:
    exepectedRoman     | integer
    'MMMMMDCCXLIX'     | 5749

    'MMMDCCXLIX'       | 3749
    'LVIII'            | 58
    'MCMXCIV'          | 1994
    'XL'               | 40

    ''  | 0
    'I' | 1
    'II' | 2
    'III' | 3
    'IV' | 4
    'V' | 5
    'VI' | 6
    'VII' | 7
    'VIII' | 8
    'IX' | 9
    'X' | 10
    'XI' | 11
    'XII' | 12
    'XIII' | 13
    'XIV' | 14
    'XV' | 15
    'XVI' | 16
    'XVII' | 17
    'XVIII' | 18
    'XIX' | 19
    'XX' | 20
  }
}
