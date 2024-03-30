package graphBFS

import spock.lang.Specification
import spock.lang.Unroll
import utils.GraphMethods
import utils.GraphMethodsImpl
import utils.SimpleGraph

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
    'hit'      | 'cog'      | ["hot","dot","dog","lot","log","cog"] | 5
    'hit'      | 'cog'      | ["hot","dot","dog","lot","log"]       | 0
  }
}