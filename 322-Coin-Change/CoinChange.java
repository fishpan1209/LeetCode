public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0 || amount<0) return -1;
        int[] dp = new int[amount+1];
        Arrays.sort(coins);
        int sum=0;
        
        while(++sum<=amount){
            int min=-1;
            for(int coin:coins){
                if(sum<coin) break;
                if(dp[sum-coin]!=-1){
                    int temp = dp[sum-coin]+1;
                    min = min<0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum]=min;
        }
        return dp[amount];
    }
}