import java.util.Hashtable;
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length<1) return false;
        Hashtable<Integer, Integer> ht = new Hashtable();
        for(int i=0; i<nums.length; i++){
            if(ht.containsKey(nums[i])){
                if((i-ht.get(nums[i]))<=k) return true;
            }
            ht.put(nums[i],i);
        }
        return false;
    }
}