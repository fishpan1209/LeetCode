import java.util.HashMap;
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            int val = nums[i];
            if(map.containsKey(target-val)){
                res[0] = map.get(target-val);
                res[1] = i;
            }
            else map.put(val, i);
        }
        return res;
    }
}