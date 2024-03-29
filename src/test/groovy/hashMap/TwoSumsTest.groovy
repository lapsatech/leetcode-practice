package hashMap

import spock.lang.Specification
import spock.lang.Unroll

class TwoSumsTest extends Specification {

  @Unroll
  def 'test'(def nums, def target, def expectedResult) {
    given:
    def subject = new TwoSums();

    when:
    def res = subject.twoSum(nums as int[], target) as int[]

    then:
    res == expectedResult as int[]

    where:
    nums           | target   | expectedResult
    [2, 7, 11, 15] | 9        | [0,1]
    [3, 2, 4]      | 6        | [1,2]
    [3, 3]         | 6        | [0,1]
  }
}
