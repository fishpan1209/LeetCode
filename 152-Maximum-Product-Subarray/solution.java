public class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int maxCur = nums[0];
        int minCur = nums[0];
        int maxSofar = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]>0){
                maxCur = Math.max(maxCur*nums[i], nums[i]);
                minCur = Math.min(minCur*nums[i], nums[i]);
            }
            else{
                int max = maxCur;
                maxCur = Math.max(minCur*nums[i], nums[i]);
                minCur = Math.min(max*nums[i], nums[i]);
            }
            maxSofar = Math.max(maxCur, maxSofar);
        }
        return maxSofar;
    }
}