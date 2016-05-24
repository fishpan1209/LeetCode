public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0]=res[1]=-1;
        if(nums==null || nums.length==0) return res;
        int start = 0, end = nums.length-1, mid;
        
        // search for left boundary
        // mid is biased towards start
        while(start<end){
            mid = (start+end)/2;
            // left boundary open
            if(nums[mid]<target) start = mid+1;
            else end = mid;
        }
        if(nums[start]==target){
            res[0] = start;
        }
       
        // search for right boundary
        // keep start where it left, move right end towards the mid
        end = nums.length-1;
        while(start < end){
            mid = (start+end)/2+1;
            // right boundary open
            if(nums[mid]>target) end = mid-1;
            else start = mid;
        }
        if(nums[end]==target){
            res[1] = end;
        }
        
        return res;
    }
}