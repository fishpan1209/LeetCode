public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums==null || nums.length==0) return;
        Arrays.sort(nums);
        int mid = 0;
        if(nums.length%2==0) mid = nums.length/2;
        else mid = nums.length/2+1;
        int[] first = new int[mid];
        int[] second = new int[nums.length-mid];
        
        for(int i=0; i<nums.length; i++){
            if(i<mid) first[i] = nums[i];
            else second[i-mid] = nums[i];
        }
       
        int i=first.length-1;
        int j=second.length-1;
        for(int k=0; k<nums.length; k++){
            if(k%2==0 && i>=0) nums[k] = first[i--];
            else if(j>=0) nums[k] = second[j--];
        }
    }
}