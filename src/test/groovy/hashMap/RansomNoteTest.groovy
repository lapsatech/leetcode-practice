package hashMap

import spock.lang.Specification
import spock.lang.Unroll

class RansomNoteTest extends Specification {

  @Unroll
  def 'test'(def ransomNote, def magazine, def expectedResult) {
    given:
    def subject = new RansomNote();

    when:
    def res = subject.canConstruct(ransomNote, magazine)

    then:
    res == expectedResult

    where:
    ransomNote   | magazine   | expectedResult
    'a'          | 'b'        | false
    'aa'         | 'ab'       | false           
    'aa'         | 'aab'      | true
  }
}
