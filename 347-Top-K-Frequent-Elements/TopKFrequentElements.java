import java.util.HashMap;
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        HashMap<Integer, Integer> map = new HashMap();
        List<Integer>[] bucket = new List[nums.length];
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i])+1);
            }
            else {
                map.put(nums[i],1);
            }
       }
       
       // put nums in bucket in the order of freq
       for(int key : map.keySet()){
           int freq = map.get(key);
           if(bucket[freq] == null){
               bucket[freq] = new ArrayList();
           }
           // bucket is ordered by freq as index
           bucket[freq].add(key);
       }
       
       for(int i= bucket.length-1; i>0 && res.size()<k; i--){
           if (bucket[i] != null) {
            res.addAll(bucket[i]);
        }
       }
       return res;
}
}