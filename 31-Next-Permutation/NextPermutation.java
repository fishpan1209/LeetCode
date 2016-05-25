public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length==0) return;
       boolean sorted = false;
        // scan from end, swap two number if not in desc order
        for(int i=nums.length-1; i>=0; i--){
            // first one breaks the pattern, swap nums[i-1] with the least number larger than it
            if(i>0 && nums[i]>nums[i-1]){
                
                for(int j=i; j<nums.length; j++){
                    if(j==nums.length-1 && nums[i-1]<nums[j]){
                        int temp = nums[i-1];
                        nums[i-1] = nums[j];
                        nums[j] = temp;
                    }
                    else if(nums[i-1]<nums[j-1] && nums[i-1]>=nums[j]){
                        //swap(nums[i-1], nums[j-1]);
                        int temp = nums[i-1];
                        nums[i-1] = nums[j-1];
                        nums[j-1] = temp;
                    }
                }
                
                // then sort i-n
                for(int k = nums.length-1; i<k; i++, k--){
                    int temp = nums[i];
                    nums[i] = nums[k];
                    nums[k] = temp;
                }
                sorted = false;
                break;
            }
            else sorted = true;
        }
        // else sort array in asc
        if(sorted) Arrays.sort(nums);
    }
}