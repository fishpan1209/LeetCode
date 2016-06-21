import java.util.HashSet;
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null || nums.length<=1) return false;
        Set<Integer> set = new HashSet();
        for(int i : nums){
            if(set.contains(i)) return true;
            else set.add(i);
        }
        return false;
    }
}