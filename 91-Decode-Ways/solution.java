public class Solution {
    public int numDecodings(String s) {
        /*
        s = 123
        build up from right =>

        num_ways ("") => 1 (empty string can be represented by empty string) (i.e. num_ways[n] = 1) NOTE: only for build up with a valid string. Empty string on it's own doesn't need to be decoded.
        num_ways ("3") => 1 (only one way), i.e. num_ways[n-1] = 1
        num_ways ("23") => "23" or "2"-"3",
        num_ways ("33") => "3""3"
        num_ways ("123") => "12"(num_ways("3")) + "1"("num_ways("23")) (i.e. num_ways[i+2] + num_ways[i+1])
        num_ways ("323") => "3"(num_ways("23")) (i.e. num_ways[i+1])

        so basically if s[i:i+1] (both included) <= 26, 
        num_ways[i+2] + num_ways[i+1]
        else:
        num_ways[i+1]
        */
        if(s==null || s.length()==0) return 0;
        int n = s.length();
        int[] dp = new int[n+1]; // n+1 for empty case
        dp[n] = 1;
        dp[n-1] = s.charAt(n-1)=='0'? 0 : 1;
        for(int i=n-2; i>=0; i--){
            if(s.charAt(i)=='0') continue;
            int num = Integer.parseInt(s.substring(i, i+2));
            dp[i] = num<=26 ? dp[i+1]+dp[i+2] : dp[i+1];
        }
        return dp[0];
    }
}