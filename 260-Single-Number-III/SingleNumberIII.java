public class Solution {
    public int[] singleNumber(int[] nums) {
        List<Integer> res = new ArrayList();
        if(nums==null || nums.length<1) return null;
        if(nums.length<3) return nums;
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])) map.put(nums[i],map.get(nums[i])+1);
            else map.put(nums[i],1);
        }
        for(int key: map.keySet()){
            if(map.get(key)==1) res.add(key);
        }
        int[] result = new int[2];
        result[0] = res.get(0);
        result[1] = res.get(1);
        return result;
    }
}