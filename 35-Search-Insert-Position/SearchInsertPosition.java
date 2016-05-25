public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums==null || nums.length==0) return 0;
        int start=0, end = nums.length-1, mid=(start+end)/2;
        while(start<end){
            mid = (start+end)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) start = mid+1;
            else end = mid-1;
        }
        if(nums[start] == target) return start;
        else return target>nums[start]?start+1:start;
    }
}