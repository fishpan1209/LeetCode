public class Solution {
    public int trap(int[] height) {
        if(height==null || height.length<=2) return 0;
        int l=0;
        int r=height.length-1;
        int res = 0;
        while(l<r && height[l+1]>=height[l]) l++;
        while(l<r && height[r-1]>=height[r]) r--;
        
        while(l<r){
            // left and right boundary
            int left = height[l];
            int right = height[r];
            
            // add volume to left edge
            if(left<=right){
                while(l<r && height[++l]<=left){
                    res += left - height[l];
                }
            }
            // add volume to right edge
            else{
                while(l<r && height[--r]<=right){
                    res += right - height[r];
                }
            }
        }
        return res;
    }
}