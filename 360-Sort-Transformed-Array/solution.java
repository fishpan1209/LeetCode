public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        
        int[] res = new int[nums.length];
      
        if(a>=0){
            int k=res.length-1;
            int i=0;
            int j=nums.length-1;
            while(i<=j){
                int p = transform(nums[i], a, b, c);
                int q = transform(nums[j], a, b, c);
                res[k--] = p>=q ? transform(nums[i++], a, b, c) :transform(nums[j--], a, b, c);
            }
        }
        else {
            int k=0;
            int i=0;
            int j=nums.length-1;
            while(i<=j){
                int p = transform(nums[i], a, b, c);
                int q = transform(nums[j], a, b, c);
                res[k++] = p<=q ? transform(nums[i++], a, b, c) :transform(nums[j--], a, b, c);
            }
        }
        return res;
        
    }
    
    public int transform(int i, int a, int b, int c){
        return a*i*i+b*i+c;
    }
}