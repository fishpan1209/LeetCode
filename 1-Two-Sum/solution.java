import java.util.HashMap;
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length<2) return new int[]{0,0};
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            int num1 = nums[i];
            int num2 = target - nums[i];
            if(map.containsKey(num2)){
                return new int[]{map.get(num2), i};
            }
            else map.put(num1, i);
        }
        return new int[]{0,0};
    }
}