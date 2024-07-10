package arrayString

import spock.lang.Specification
import spock.lang.Unroll

class FindTheIndexOfTheFirstOccurenceInAStringTest extends Specification {

  @Unroll
  def 'test'(def haystack, def needle, def expect) {
    given:
    def s = new FindTheIndexOfTheFirstOccurenceInAString();

    when:
    def res = s.strStr(haystack, needle)

    then:
    res == expect

    where:
    haystack      | needle  | expect
    'a'           | 'a'     | 0
    'mississippi' | 'issip' | 4
    'leetcode'    | 'leeto' | -1
    'sadbutsad'   | 'sad'   | 0
    
  }
}