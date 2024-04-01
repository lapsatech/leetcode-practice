package arrayString

import spock.lang.Specification
import spock.lang.Unroll

class RotateArrayTest extends Specification {

  @Unroll
  def 'test'(def input, def k, def expectAry) {
    given:
    def s = new RotateArray()
    int[] ary = input as int[]

    when:
    s.rotate(ary, k)

    then:
    ary == expectAry as int[]

    where:
    input                         | k     | expectAry
    [10, 20, 30, 40, 50, 60]      | 0     | [10, 20, 30, 40, 50, 60]
    [10, 20, 30, 40, 50, 60]      | 6000  | [10, 20, 30, 40, 50, 60]
    [10, 20, 30, 40, 50, 60]      | 6001  | [60, 10, 20, 30, 40, 50]
    [10, 20, 30, 40, 50, 60]      | 6002  | [50, 60, 10, 20, 30, 40]
    [10, 20, 30, 40, 50, 60]      | -6000 | [10, 20, 30, 40, 50, 60]
    [10, 20, 30, 40, 50, 60]      | -6001 | [20, 30, 40, 50, 60, 10]
    [10, 20, 30, 40, 50, 60]      | -6002 | [30, 40, 50, 60, 10, 20]

    [1, 2, 3, 4, 5, 6, 7]         | 3     | [5, 6, 7, 1, 2, 3, 4]
    [-1, -100, 3, 99]             | 2     | [3, 99, -1, -100]
  }
}