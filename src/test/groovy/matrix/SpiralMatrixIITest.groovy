package matrix

import spock.lang.Specification
import spock.lang.Unroll

class SpiralMatrixIITest extends Specification {

  @Unroll
  def 'test'(int n, def expected) {
    given:
    def subject = new SpiralMatrixII();

    when:
    def res = subject.generateMatrix(n)

    then:
    res as int[][] == expected as int[][]

    where:
    n  | expected
    1  | [[1]]
    2  | [[1, 2],
          [4, 3]]
    3  | [[1, 2, 3],
          [8, 9, 4],
          [7, 6, 5]]
    4  | [[ 1,  2,  3, 4],
          [12, 13, 14, 5],
          [11, 16, 15, 6],
          [10,  9,  8, 7]]
    5  | [[ 1,  2,  3,  4, 5],
          [16, 17, 18, 19, 6],
          [15, 24, 25, 20, 7],
          [14, 23, 22, 21, 8],
          [13, 12, 11, 10, 9]]
  }
}
