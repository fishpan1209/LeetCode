public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        // if empty set, return false
        if(wordDict==null || wordDict.size()==0) return false;
        // if empty string, return true
        if(s==null || s.length()==0) return true;
        
        // dp
        int n = s.length();
        boolean dp[] = new boolean[n+1];
        // empty string
        dp[0] = true;
        
        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                dp[i] = (wordDict.contains(s.substring(j, i)) && dp[j]);
                // break whenever found a pair
                if(dp[i]) break;
            }
        }
        return dp[n];
    }
}