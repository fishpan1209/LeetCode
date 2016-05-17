public class Solution {
    public int maxArea(int[] height) {
        if(height==null || height.length<2) return 0;
        int max=0;
        int i=0, j=height.length-1;
        while(i<j){
            int h = Math.min(height[i],height[j]);
            int area = (j-i)*h;
            if (height[i]<height[j]) i++;
            else j--;
            max = Math.max(max, area);
        }
    
        return max;
    }
}