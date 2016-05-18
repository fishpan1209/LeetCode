import java.util.TreeSet;
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null || nums.length<1) return false;
        final TreeSet<Long> values = new TreeSet<>();
        for(int i=0; i<nums.length; i++){
            // if nums[i]=Integer.MAX_VALUE, automatically handles overflow
            // type must be Long, not long!
            // TreeSet.floor(): get the floor value within the range [nums[i], nums[i]+t]
            Long floor = values.floor((long) nums[i]+t);
            // nums[i]-floor<=t, true
            if(floor != null && floor + t >= nums[i]){
                return true;
            }
            
            values.add((long) nums[i]);
            if(i>=k){
                values.remove((long) nums[i-k]);
            }
        }
        return false;
    }
}