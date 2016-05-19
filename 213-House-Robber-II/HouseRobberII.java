public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(nums==null || len==0) return 0;
        if(len==1) return nums[0];
        if(len==2) return Math.max(nums[0],nums[1]);
        // call two runs, then pick max
        return Math.max(rob(nums, 0, len-1), rob(nums, 1, len));
    }
    
    public int rob(int[] nums, int start, int end){
        int n = end-start;
        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start],nums[start+1]);
        for(int i= 2; i<n; i++){
            // nums[i+start] instead of nums[i] because i start differently
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i+start]);
        }
        return dp[n-1];
    }
}