package arrayString

import spock.lang.Specification
import spock.lang.Unroll

class ProductOfArrayExceptSelfTest extends Specification {

  @Unroll
  def 'test'(def input, def expectAry) {
    given:
    def s = new ProductOfArrayExceptSelf()
    int[] inputAry = input as int[]

    when:
    def resAry = s.productExceptSelf(inputAry) as int[]

    then:
    resAry == expectAry as int[]

    where:
    input                         | expectAry
    [1, 2, 3, 4]                  | [24, 12, 8, 6]
    [-1,1,0,-3,3]                 | [0, 0, 9, 0, 0]
  }
}