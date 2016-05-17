public class Solution {
    public int missingNumber(int[] nums) {
        //  a number XOR itself will become 0, any number XOR with 0 will stay unchanged. 
        // So if every number from 1...n XOR with itself except the missing number, the result will be the missing number.
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
        res ^= i;
        res ^= nums[i];
        }
        return res;
        
    }
}