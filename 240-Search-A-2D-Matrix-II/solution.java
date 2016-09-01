public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // start from up right corner to bottom left corner
        if(matrix==null || matrix.length==0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int row = 0;
        int col = n-1;
        while(row<m && col>=0){
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]<target) row++;
            else col--;
        }
        
        return false;
    }

}
