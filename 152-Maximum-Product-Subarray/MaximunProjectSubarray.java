public class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int max_cur = nums[0];
        int min_cur = nums[0];
        int max_sofar = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]>0){
                max_cur = Math.max(max_cur*nums[i], nums[i]);
                min_cur = Math.min(min_cur*nums[i], nums[i]);
            }
            else{
                int temp = max_cur; // save current max before it's changed
                // use previous min*nums[i] to get current max
                max_cur = Math.max(min_cur*nums[i], nums[i]);
                // use previous max*nums[i] to get current min, because num[i]<0
                min_cur = Math.min(temp*nums[i], nums[i]);
            }
            max_sofar = Math.max(max_cur, max_sofar);
        }
        return max_sofar;
    }
}