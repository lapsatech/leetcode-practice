package arrayString

import spock.lang.Specification
import spock.lang.Unroll

class RemoveElementTest extends Specification {

  @Unroll
  def 'test'(def nums, def val, def expectK, def expectAry) {
    given:
    def s = new RemoveElement();
    def numsAry = nums as int[]

    when:
    def k = s.removeElement(numsAry, val as int) as int
    def cpy = Arrays.copyOf(numsAry, k)
    Arrays.sort(cpy)

    then:
    k == expectK
    cpy == expectAry

    where:
    nums                     | val | expectK  | expectAry
    [3, 2, 2, 3]             | 3   | 2        | [2, 2]
    [0, 1, 2, 2, 3, 0, 4, 2] | 2   | 5        | [0, 0, 1, 3, 4]
  }
}