public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums==null || nums.length<=1) return;
        for(int i=0; i<nums.length; i++){
            if(i%2==1){
                // for all odd number, nums[i]>=nums[i-1]
                if(nums[i]<nums[i-1]) swap(nums, i, i-1);
            }
            // for all even number
            else if(i!=0 && nums[i-1]<nums[i]) swap(nums, i, i-1);
        }
    }
    
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}