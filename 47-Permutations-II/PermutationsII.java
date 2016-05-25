import java.util.HashSet;
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        res.add(new ArrayList());
        for(int i=0; i<nums.length; i++){
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            // use a set to remove duplicate lists
            HashSet<String> set = new HashSet();
            for(int j=0; j<=i; ++j){
                for(List l: res){
                    List<Integer> new_list = new ArrayList(l);
                    new_list.add(j, nums[i]);
                    if(set.contains(new_list.toString())) continue;
                    else {
                        set.add(new_list.toString());
                        temp.add(new_list);
                    }
                }
            }
            res = temp;
        }
        return res;
    }
}