public class Solution {
    public void sortColors(int[] nums) {
        // insertion sort, O(n2), O(1)
        if(nums==null || nums.length<2) return;
        for(int i=1; i<nums.length; i++){
            for(int j=i; j>0; j--){
                if(nums[j]<nums[j-1]) {
                    int temp =nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
    }
 
}