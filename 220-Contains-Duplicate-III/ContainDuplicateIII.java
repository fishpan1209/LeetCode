public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null || nums.length<1 || k>nums.length) return false;
        for(int i=0; i<nums.length-k; i++){
            for(int j=i+1; j<=i+k; j++){
                if(Math.abs(nums[j]-nums[i])<=t) return true;
            }
        }
        return false;
    }
}