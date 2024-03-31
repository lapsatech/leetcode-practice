package graphBFS

import spock.lang.Specification
import spock.lang.Unroll

class WordLadderTest extends Specification {

  @Unroll
  def 'test'(def beginWord, def endWord, def wordList, def expectResult) {
    given:
    def subject = new WordLadder();

    when:
    def result = subject.ladderLength(beginWord, endWord, wordList)

    then:
    result == expectResult

    where:
    beginWord  | endWord    | wordList                              | expectResult
    'hit'      | 'cog'      | ["cog","dog","dot","hot","log","lot"] | 5
    'hit'      | 'cog'      | ["hot","dot","dog","lot","log"]       | 0
  }
}