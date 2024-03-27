package arrayString

import spock.lang.Specification
import spock.lang.Unroll

class LongestCommonPrefixTest extends Specification {

  @Unroll
  def 'test'(def strings, def expectedPrefix) {
    given:
    def subject = new LongestCommonPrefix();
    def stringsArray = strings as String[]

    when:
    def prefix = subject.longestCommonPrefix(stringsArray)

    then:
    prefix == expectedPrefix

    where:
    strings                        | expectedPrefix
    [ 'flower', 'flow', 'flight' ] | 'fl'
    [ 'dog', 'racecar', 'car' ]    | '' 
    [ '', 'racecar', 'car' ]       | ''
    [ 'dog', '', 'car' ]           | ''
    []                             | ''

  }
}
