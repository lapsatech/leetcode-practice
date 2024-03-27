package hashMap

import spock.lang.Specification
import spock.lang.Unroll

class ValidAnagramTest extends Specification {

  @Unroll
  def 'test'(def s1, def s2, def expectedResult) {
    given:
    def subject = new ValidAnagram();

    when:
    def res = subject.isAnagram(s1, s2)

    then:
    res == expectedResult

    where:
    s1                           | s2                           | expectedResult
    'anagram'                    | 'nagaram'                    | true
    'rat'                        | 'car'                        | false
    'ab'                         | 'a'                          | false
    'a'                          | 'ab'                         | false
    'abcdefghijklmnopqrstuvwxyz' | 'abcdefghijklmnopqrstuvwxyz' | true
  }
}
