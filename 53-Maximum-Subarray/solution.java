public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int maxCur = nums[0];
        int maxSofar = nums[0];
        for(int i=1; i<nums.length; i++){
            maxCur = Math.max(maxCur+nums[i], nums[i]);
            maxSofar = Math.max(maxSofar, maxCur);
        }
        return maxSofar;
    }
}