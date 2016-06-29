public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0) return 0;
        int n = triangle.size();
        int[] dp = new int[n];
        
        // set dp[i] to the nodes of last row
        for(int i=0; i<n; i++){
            dp[i] = triangle.get(n-1).get(i);
        }
        
        // from last-1 row, 
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                dp[j] = Math.min(dp[j], dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}