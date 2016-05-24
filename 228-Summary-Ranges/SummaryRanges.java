public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList();
        if(nums==null || nums.length==0) return res;
        boolean open = true;
        // i must reach len-1
        for(int i=0; i<nums.length; i++){
            int start = nums[i];
            // i must smaller than len-1
            while(i<nums.length-1 && nums[i+1]==nums[i]+1) i++;
            int end = nums[i];
            
            if(start==end) res.add(Integer.toString(start));
            else  res.add(start+"->"+end);
        }
        return res;
    }
}