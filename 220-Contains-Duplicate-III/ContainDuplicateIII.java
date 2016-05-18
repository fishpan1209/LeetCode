public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null || nums.length<1) return false;
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<=i+k; j++){
                if(Math.abs(nums[j]-nums[i])<=t) return true;
            }
        }
        return false;
    }
}