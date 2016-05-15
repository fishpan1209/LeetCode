public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length==0 || k==0) return;
        int len = nums.length;
        int[] temp = new int[k];
        for (int i=0; i<k; i++){
           temp[i] = nums[len-k+i]; 
        }
        
        for(int i=len-1; i>=0; i--){
            if(i>k-1) nums[i] = nums[i-k];
            else nums[i] = temp[i];
        }
    }
}