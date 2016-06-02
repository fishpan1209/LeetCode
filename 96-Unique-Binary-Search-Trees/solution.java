public class Solution {
    public int numTrees(int n) {
        //the number of unique BST when picking i as root: f(i) = G(i-1)*G(n-i)
        // so from 1:n, total number of BST G(i) = sum(f)
        int[] dp = new int[n+1]; // n starts from 1
        dp[0] = dp[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}