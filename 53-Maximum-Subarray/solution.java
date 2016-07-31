public class Solution {
    /*
    // dp solution
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int len = nums.length;
        int maxCur = nums[0];
        int res = maxCur;
        for(int i=1; i<len; i++){
            maxCur = Math.max(nums[i], nums[i]+maxCur);
            res = Math.max(res, maxCur);
        }
        return res;
    }
    */
    
    // divide and conqure
    public int maxSubArray(int[] nums){
        if(nums==null || nums.length==0) return 0;
        int n = nums.length;
        return subarray(nums, 0, n-1);
    }
    
    public int subarray(int[] nums, int start, int end){
        if(start==end) return nums[start];
        int mid = (start+end)/2;
        int left = subarray(nums, start, mid);
        int right = subarray(nums, mid+1, end);
        
        int leftMax = nums[mid];
        int rightMax = nums[mid+1];
        
        int leftCur = leftMax;
        for(int i=mid-1; i>=0; i--){
            leftCur += nums[i];
            leftMax = Math.max(leftMax, leftCur);
        }
        
        int rightCur = rightMax;
        for(int j=mid+2; j<=end; j++){
            rightCur += nums[j];
            rightMax = Math.max(rightMax, rightCur);
        }
        
        return Math.max(Math.max(left, right), leftMax+rightMax);
    }
}