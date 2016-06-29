public class Solution {
    public int minCostII(int[][] costs) {
        if(costs==null || costs.length==0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        int min = Integer.MAX_VALUE;
        // for each house, calculate the min cost of using each color
        // for the last house, pick the min cost among all colors
        for(int i=0; i<n; i++){
            // the first house
            if(i==0) dp[i] = costs[i];
            else{
                // must save dp[i-1] first because it will be changed when calculating min
                int[] cur = dp[i-1];
                for(int j=0; j<k; j++){
                    // calculate the min cost except color j
                    dp[i][j] = costs[i][j]+min(cur, j);
                }
            }
        }
        for(int m=0; m<k; m++){
            min = Math.min(dp[n-1][m], min);
        }
       
        return min;
    }
    
    // min except j
    public int min(int[] cost, int j){
        int min=Integer.MAX_VALUE;
        for(int i=0; i<cost.length; i++){
            if(i==j) continue;
            else min = Math.min(min, cost[i]);
        }
        return min;
    }
}