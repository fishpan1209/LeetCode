public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int n = nums.length;
        if(n==1) return nums[0];
        int[] dp = new int[n+1];
        dp[0] = nums[0];
        int maxSofar = nums[0];
        for(int i=1; i<n; i++){
            maxSofar = Math.max(nums[i], maxSofar+nums[i]);
            dp[i] = Math.max(maxSofar, dp[i-1]);
        }
        return dp[n-1];
    }
}