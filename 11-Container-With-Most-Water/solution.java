public class Solution {
    public int maxArea(int[] height) {
        if(height==null || height.length<=1) return 0;
        int max = 0;
        int l = 0;
        int r = height.length-1;
        while(l<r){
            int left = height[l];
            int right = height[r];
            int low = Math.min(left, right);
            int area = low*(r-l);
            max = Math.max(max, area);
            if(height[l]<height[r]) l++;
            else r--;
        }
        return max;
    }
}