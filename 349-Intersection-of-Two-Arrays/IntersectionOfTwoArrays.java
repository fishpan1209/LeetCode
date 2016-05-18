import java.util.Hashtable;
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Hashtable<Integer, Integer> ht = new Hashtable();
        Hashtable<Integer, Integer> res = new Hashtable();
        
        for(int i=0; i<nums1.length; i++){
            if(!ht.containsKey(nums1[i])){
                ht.put(nums1[i],i);
            }
        }
        
        for(int j=0; j<nums2.length; j++){
            if(ht.containsKey(nums2[j])){
                res.put(nums2[j],j);
            }
        }
        
        int[] result = new int[res.size()];
        int len=0;
        for(Integer r : res.keySet()){
            result[len++] = r;
        }
        
        return result;
    }
}