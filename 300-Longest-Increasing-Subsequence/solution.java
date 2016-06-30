public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length<=1) return nums.length;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1; i<n; i++){
            dp[i] = 1;
         
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i]) {
                    dp[i] = (dp[j]+1)>dp[i] ? (dp[j]+1) : dp[i];
                }
                
            }
        }
        
        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}