public class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length==0) return false;
        int maxLoc = 0;
        for(int i=0; i<nums.length; i++){
            if(maxLoc<i) return false; // can not reach location i
            maxLoc = maxLoc>i+nums[i]? maxLoc: i+nums[i]; // greedy
        }
        return true;
    }
}