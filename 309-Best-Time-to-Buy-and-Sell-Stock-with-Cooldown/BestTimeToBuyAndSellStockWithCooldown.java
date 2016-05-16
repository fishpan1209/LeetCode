public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2) return 0;
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;//prev_buy=buy(i-1)
            buy = Math.max(prev_sell - price, prev_buy);//prev_sell = sell(i-2)
            prev_sell = sell;//prev_sell = sell(i-1)
            sell = Math.max(prev_buy + price, prev_sell);
        }
    
        return sell;
    }
}