public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // use a priority queue
        // Performance wise: remove() and contains() methods take linear time. peek(), element() and size() takes fixed time. offer(), poll() and remove() takes O(log n) time.
        
        // count each num frequency and store in map
        HashMap<Integer, Integer> freqMap = new HashMap();
        for(int i : nums){
            freqMap.put(i, freqMap.getOrDefault(i,0)+1);
        }
        
        // put mapentry to priority queue
        PriorityQueue<Entry> queue = new PriorityQueue<Entry>(k, new EntryComparator());
        for(int key : freqMap.keySet()){
            queue.add(new Entry(key, freqMap.get(key)));
        }
        
        // poll values(Entry) from queue, add to res list
        List<Integer> res = new ArrayList();
        for(int i=0; i<k; i++) {
            res.add(queue.poll().key);
        }
        
        return res;
    }
    
    public class EntryComparator implements Comparator<Entry>{
        @Override
        public int compare(Entry e1, Entry e2){
            // decreasing order, so e2 comes first
            return e2.value-e1.value;
        }
    }
    
    public class Entry{
        int key;
        int value;
        
        public Entry(int key, int value){
            this.key = key;
            this.value = value;
        }
        
        public int compareTo(Entry e){
            return this.value-e.value;
        }
        
    }
}
