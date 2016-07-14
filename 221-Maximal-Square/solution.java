public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int[][] dp = new int[m+1][n+1];  // default=0
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(matrix[i-1][j-1]=='1'){
                    // dp[i][j] is at the lower right corner of formed square, dp is the side len of the square
                    // if matrix[i-1][j], matrix[i][j-1], matrix[i-1][j-1] all equals 1, then a square is formed, side length +=1
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1])+1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res*res;
    }
}