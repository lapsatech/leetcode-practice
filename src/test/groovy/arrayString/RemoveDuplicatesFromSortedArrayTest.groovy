package arrayString

import arrayString.RemoveDuplicatesFromSortedArray
import spock.lang.Specification
import spock.lang.Unroll

class RemoveDuplicatesFromSortedArrayTest extends Specification {

  @Unroll
  def 'test'(def input, def expect, def expectAry) {
    given:
    def s = new RemoveDuplicatesFromSortedArray();
    int[] inputAry = input as int[]

    when:
    def res = s.removeDuplicates(inputAry) as int

    then:
    res == expect

    when:
    def resAry = Arrays.copyOf(inputAry, res) as int[]

    then:
    resAry == expectAry as int[]

    where:
    input                          | expect | expectAry
    [1, 1, 2]                      | 2      | [1, 2]
    [0, 0, 1, 1, 1, 2, 2, 3, 3, 4] | 5      | [0, 1, 2, 3, 4]
  }
}