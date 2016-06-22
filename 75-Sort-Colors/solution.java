public class Solution {
    public void sortColors(int[] nums) {
        // insertion sort, O(n2), O(1)
        /*
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
    */
    
    // put all 0s to left and 2s to right
    int i=0;
    int n = nums.length-1; 
    for(int k=0; k<=n; k++){
        while(nums[k]==2 && k<n) {
            int t = nums[k];
            nums[k] = nums[n];
            nums[n] = t;
            n--;
        }
        while(nums[k]==0 && k>i) {
            int t = nums[k];
            nums[k] = nums[i];
            nums[i] = t;
            i++;
        }
    }
    }
 
}