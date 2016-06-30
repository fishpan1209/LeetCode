public class Solution {
    public int integerBreak(int n) {
        if(n<=1) return 0;
        if(n==2) return 1;
        if(n==3) return 2;
        if(n==4) return 4;
        int max = 1;
        while(n>4){
            n -= 3;
            max *= 3;
        }
        return max*n;
    }
}