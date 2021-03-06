public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1) return 0;
        int min = prices[0];
        int max = 0;
        for(int i=1; i<prices.length; i++){
            min = prices[i]<min? prices[i] : min;
            max = prices[i]-min > max ? prices[i]-min : max;
        }
        return max;
    }
}