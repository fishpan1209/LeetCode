public class Solution {
    public int titleToNumber(String s) {
        int n = s.length();
        int sum=0;
        for(int i=0; i<n; i++){
            sum += Math.pow(26, n-i-1)*(s.charAt(i)-'A'+1);
        }
        return sum;
    }
}