public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int max_cur = nums[0];
        int max_sofar = nums[0];
        for(int i=1; i<nums.length; i++){
            max_cur = Math.max(max_cur+nums[i], nums[i]);
            max_sofar = Math.max(max_cur, max_sofar);
        }
        return max_sofar;
    }
}