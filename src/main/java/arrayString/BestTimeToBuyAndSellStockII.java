package arrayString;

public class BestTimeToBuyAndSellStockII {

  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int profit = 0, buy, sell;
    int i = 0;
    while (i < prices.length) {
      buy = prices[i];
      sell = buy;
      while (++i < prices.length && prices[i] > sell) {
        // price is going higher
        sell = prices[i];
      }
      profit += sell - buy;
    }
    return profit;
  }
}
