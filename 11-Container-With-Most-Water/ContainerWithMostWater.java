public class Solution {
    public int maxArea(int[] height) {
        if(height==null || height.length<2) return 0;
        int max=0;
        for(int i=0; i<height.length-1; i++){
            for(int j=height.length-1; j>0; j--){
                int h = height[i]<height[j]? height[i]:height[j];
                int area = h*(j-i);
                max = max>area? max: area;
            }
        }
        return max;
    }
}