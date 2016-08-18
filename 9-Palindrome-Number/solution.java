public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x<10) return true;
        long yl = 0;
        long xl = (long) x;
        while(xl>0){
            yl = yl*10+xl%10;
            xl /= 10;
        }
        return ((long) x) == yl;
    }
}