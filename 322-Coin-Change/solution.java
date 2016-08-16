public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0) return -1;
        int[] dp = new int[amount];
        return helpler(coins, amount, dp);
    }
    
    public int helpler(int[] coins, int amount, int[] dp){
        if(amount<0) return -1;
        else if(amount==0) return 0;
        
        if(dp[amount-1]!=0) return dp[amount-1];
        
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int remain = helpler(coins, amount-coin, dp);
            if(remain>=0 && remain<min){
                min = remain+1;
            }
        }
        dp[amount-1] = min==Integer.MAX_VALUE ? -1 : min;
        return dp[amount-1];
    }
}