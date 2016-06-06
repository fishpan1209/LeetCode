public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Numbers:     2    3    4     5
        // Lefts:       1    2  2*3 2*3*4
        // Rights:  3*4*5  4*5    5     1
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i=1; i<n; i++){
            res[i] = nums[i-1]*res[i-1];
        }
        int right = 1;
        for(int i=n-1; i>=0; i--){
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}