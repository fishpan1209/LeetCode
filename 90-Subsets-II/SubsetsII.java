public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) {
            res.add(new ArrayList());
            return res;
        }
        subsets(nums, res, new ArrayList(),0);
        return res;
    }
    
    public void subsets(int[] nums, List<List<Integer>> res, List<Integer> temp, int start){
        if(start<=nums.length){
            res.add(temp);
        }
        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            subsets(nums, res, new ArrayList(temp),i+1);
            temp.remove(temp.size()-1);
        }
        
    }
}