public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums==null || nums.length==0) return res;
        for(int i=0; i<nums.length-1; i++){
            int num1 = nums[i];
            for(int j=i+1; j<nums.length; j++){
                int num2 = nums[j];
                if(num1+num2==target){
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }
}