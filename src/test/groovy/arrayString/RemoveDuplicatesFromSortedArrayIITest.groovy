package arrayString

import arrayString.RemoveDuplicatesFromSortedArray
import spock.lang.Specification
import spock.lang.Unroll

class RemoveDuplicatesFromSortedArrayIITest extends Specification {

  @Unroll
  def 'test'(def input, def expect, def expectAry) {
    given:
    def s = new RemoveDuplicatesFromSortedArrayII()
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
    input                         | expect | expectAry
    [1, 1, 1, 2, 2, 3]            | 5      | [1, 1, 2, 2, 3]
    [0, 0, 1, 1, 1, 1, 2, 3, 3]   | 7      | [0, 0, 1, 1, 2, 3, 3]
    [1, 2, 2]                     | 3      | [1, 2, 2]
    [10, 10, 10, 20, 30, 30, 30,
       40, 40, 40, 40, 40]        | 7      | [10, 10, 20, 30, 30, 40, 40]
  }
}