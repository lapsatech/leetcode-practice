package arrayString

import spock.lang.Specification
import spock.lang.Unroll

class BestTimeToBuyAndSellStockIITest extends Specification {

  @Unroll
  def 'test'(def input, def expect) {
    given:
    def s = new BestTimeToBuyAndSellStockII();

    when:
    def res = s.maxProfit(input as int[]) as int

    then:
    res == expect

    where:
    input                 | expect
    [7, 1, 5, 3, 6, 4]    | 7
    [1, 2, 3, 4, 5]       | 4
    [7, 6, 4, 3, 1]       | 0
  }
}