public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int len = nums.length;
        int maxCur = nums[0];
        int res = maxCur;
        for(int i=1; i<len; i++){
            maxCur = Math.max(nums[i], nums[i]+maxCur);
            res = Math.max(res, maxCur);
        }
        return res;
    }
}