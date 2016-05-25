public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        // add an empty list for first element
        res.add(new ArrayList());
        for(int i=0; i<nums.length; ++i){
            // use a temp list to keep intermediate stages
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            // use ++j to prevent index out of range
            for(int j=0; j<=i; ++j){
                for(List l : res){
                    // copy old list
                    List<Integer> new_list = new ArrayList(l);
                    // at each position, add nums[i]
                    // add nums[i], not nums[j]
                    new_list.add(j, nums[i]);
                    temp.add(new_list);
                }
            }
            res = temp;
        }
        return res;
    }
}