import java.util.HashMap;
public class Solution {
    public int singleNumber(int[] nums) {
        /*
        if(nums==null || nums.length==0) return 0;
        
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            // remove all duplicate nums, the only left is the answer
            if(map.containsKey(nums[i])) map.remove(nums[i]);
            else map.put(nums[i], i);
        }
        int res=0;
        // if more than one single num, return
        if(map.size()!=1) return 0;
        else{
            for(int key : map.keySet()){
                res = key;
            }
        }
        return res;
        */
        
        // O(n) method: bit manipulation
        // XOR : if same, return 0, else 1; A XOR A = 0; A XOR B = 1
        int res = 0;
        for(int i=0; i<nums.length; i++){
            res ^= nums[i];
        }
        return res;
    }
}