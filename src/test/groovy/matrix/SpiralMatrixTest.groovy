package matrix

import spock.lang.Specification
import spock.lang.Unroll

class SpiralMatrixTest extends Specification {

  @Unroll
  def 'test'(def matrix, def expected) {
    given:
    def subject = new SpiralMatrix();

    when:
    def res = subject.spiralOrder(matrix as int[][])

    then:
    res == expected

    where:
    matrix                   | expected
    [
      [1]
    ]                        | [1]
    [
      [1, 2], 
      [4, 3]
    ]                        | [1,2,3,4]
    [
      [1, 2, 3],
      [8, 9, 4],
      [7, 6, 5]
    ]                        | [1,2,3,4,5,6,7,8,9]
    [
      [ 1,  2,  3, 4],
      [12, 13, 14, 5],
      [11, 16, 15, 6],
      [10,  9,  8, 7]
    ]                        | [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
    [
      [ 1,  2,  3,  4, 5],    
      [16, 17, 18, 19, 6],
      [15, 24, 25, 20, 7],
      [14, 23, 22, 21, 8],
      [13, 12, 11, 10, 9]
    ]                        | [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25]
    [
      [1,  2,  3,  4],
      [5,  6,  7,  8],
      [9, 10, 11, 12]
    ]                        | [1,2,3,4,8,12,11,10,9,5,6,7]
  }
}
