public class Solution {
    public int maxProfit(int[] prices) {
        // buy[i] = Math.max(buy[i-1], sell[i-2]-prices[i]); before day i, hold
        // sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]); before day i, sell
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
}