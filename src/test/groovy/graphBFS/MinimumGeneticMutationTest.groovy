package graphBFS

import spock.lang.Specification
import spock.lang.Unroll

class MinimumGeneticMutationTest extends Specification {

  @Unroll
  def 'test'(def startGene, def endGene, def bank, def expectResult) {
    given:
    def subject = new MinimumGeneticMutation();

    when:
    def result = subject.minMutation(startGene as String, endGene as String, bank as String[])

    then:
    result == expectResult

    where:
    startGene  | endGene    | bank            | expectResult
    'AACCGGTT' | 'AACCGGTA' | ['AACCGGTA']    | 1
    'AACCGGTT' | 'AAACGGTA' | [
                                'AACCGGTA', 
                                'AACCGCTA',
                                'AAACGGTA']   | 2
    'AACCGGTT' | 'AACCGGTA' | []              | -1
  }
}