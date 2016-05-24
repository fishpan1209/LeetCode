import java.util.HashMap;
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null) return null;
        int len = nums1.length > nums2.length? nums2.length : nums1.length;
        int[] res = new int[len];
        int count=0;
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums1.length; i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i],map.get(nums1[i])+1);
            }
            else {
                map.put(nums1[i],1);
            }
        }
     
        for(int j=0; j<nums2.length; j++){
            if(map.containsKey(nums2[j]) && map.get(nums2[j])>0){
                map.put(nums2[j], map.get(nums2[j])-1);
                res[count++]=nums2[j];
            }
        }
       
        return Arrays.copyOfRange(res, 0, count);
        
    }
}