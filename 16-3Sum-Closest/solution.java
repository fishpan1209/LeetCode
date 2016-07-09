public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length<3) return Integer.MIN_VALUE;
        Arrays.sort(nums);
        int min = nums[0]+nums[1]+nums[2];
        int sum = 0;
        for(int i=0; i<nums.length-2; i++){
            int j= i+1;
            int k = nums.length-1;
            while(j<k){
                sum = nums[i]+nums[j]+nums[k];
                if(sum==target) return sum;
                if(Math.abs(target-min)>Math.abs(target-sum)){
                    min = sum;
                }
                if(sum>target) k--;
                else j++;
            }
        }
        return min;
    }
}