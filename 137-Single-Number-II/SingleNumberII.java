public class Solution {
    public int singleNumber(int[] nums) {
        if(nums==null || nums.length<1) return 0;
        if(nums.length==1) return nums[0];
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])) map.put(nums[i],map.get(nums[i])+1);
            else map.put(nums[i],1);
        }
        for(int key: map.keySet()){
            if(map.get(key)==1) return key;
        }
        return 0;
    }
}