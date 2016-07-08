public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length==0) return;
        int i=0;
        while(i<nums.length-1){
            while(nums[i]!=0) {
                i++;
                if(i==nums.length-1) return;
            }
            int j=i+1;
            while(nums[j]==0 && j<nums.length-1) j++;
            
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
        }
        return;
    }
}