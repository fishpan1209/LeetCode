import java.util.HashMap;
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList();
        if(nums==null || nums.length==0) return res;
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])) map.put(nums[i],map.get(nums[i])+1);
            else map.put(nums[i],1);
        }
        for(int key : map.keySet()){
            if(map.get(key)>nums.length/3) res.add(key);
        }
        return res;
    }
}