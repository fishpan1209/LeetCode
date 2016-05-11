public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row=triangle.size();
        int col = triangle.get(row-1).size();
        if(row==0) return 0;
        if(row==1) return triangle.get(0).get(0);
        int[] dp = new int[row+1];
        // start from calculating last row
        for(int i=row-1; i>=0; i--){
            List<Integer> lastRow = triangle.get(i);
            for(int j=0;j<lastRow.size();j++) dp[j] = Math.min(dp[j],dp[j+1])+lastRow.get(j);
        }
        return dp[0];
    }
}