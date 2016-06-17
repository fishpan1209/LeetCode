import java.util.HashMap;
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // brute force, time O(n2), space O(1)
        // HashMap, time O(n), space, O(n)
        /*
        int[] res = new int[2];
        if(nums==null || nums.length==0) return res;
        for(int i=0; i<nums.length-1; i++){
            int num1 = nums[i];
            for(int j=i+1; j<nums.length; j++){
                int num2 = nums[j];
                if(num1+num2==target){
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
        */
        
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            int num1 = nums[i];
            int num2 = target - num1;
            // check if num1's complimentary num already exists in map
            if(map.containsKey(num2)){
                // put i on second
                return new int[]{map.get(num2), i};
            }
            map.put(num1, i);
        }
        return null;
    }
}