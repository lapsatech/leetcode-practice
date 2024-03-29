package arrayString

import arrayString.BestTimeToBuyAndSellStock
import spock.lang.Specification
import spock.lang.Unroll

class BestTimeToBuyAndSellStockTest extends Specification {

  @Unroll
  def 'test'(def input, def expect) {
    given:
    def s = new BestTimeToBuyAndSellStock();

    when:
    def res = s.maxProfit(input as int[]) as int

    then:
    res == expect

    where:
    input              | expect
    []                 | 0
    [5, 4, 3, 2, 1]    | 0
    [7, 1, 5, 3, 6, 4] | 5
    [7, 6, 4, 3, 1]    | 0
  }
}