public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max=0;
        int[] height = new int[n];  // number of continuous "1"
        int[] left = new int[n];    // left boundary
        int[] right = new int[n];    // right boundary
        for(int i=0; i<n; i++) right[i] = n;
        
        for(int i=0; i<m; i++){
            int cur_right = n;
            for(int j=n-1; j>=0; j--){
                if(matrix[i][j]=='1'){
                    right[j] = Math.min(right[j], cur_right);
                }
                else{
                    right[j] = n;
                    cur_right = j;
                }
            }
            int cur_left = 0;
            for(int j=0; j<n; i++){
                if(matrix[i][j]=='1'){
                    height[j]++;
                    left[j] = Math.max(left[j],cur_left);
                }
                else{
                    height[j] = 0;
                    left[j] = 0;
                    cur_left++;
                }
                max = Math.max(max, right[j]-left[j])*height[j];
            }
            
        }
        return max;
    }
}