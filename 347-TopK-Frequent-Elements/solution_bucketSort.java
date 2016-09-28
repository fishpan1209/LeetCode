public class Solution {
    // bucket sort, O(n)
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        // count each num frequency and store in map
        HashMap<Integer, Integer> freqMap = new HashMap();
        for(int i : nums){
            freqMap.put(i, freqMap.getOrDefault(i,0)+1);
        }
        
        // put mapentry to a bucket
        List<Integer>[] bucket = new List[nums.length+1];
        for(int key : freqMap.keySet()){
            int freq = freqMap.get(key);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList();
            }
            bucket[freq].add(key);
        }
        
        // pull ranks from bucket and add to res
        List<Integer> res = new ArrayList();
        for(int i=bucket.length-1; i>=0 && res.size()<k; i--) {
            if(bucket[i]!=null) res.addAll(bucket[i]);
        }
        
        return res;
    }
 }
