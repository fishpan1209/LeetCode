public class Solution {
    public boolean isHappy(int n) {
        if(n==0) return false;
        int slow = n;
        int fast = n;
        do{
            slow = sum(slow);
            fast = sum(fast);
            fast = sum(fast);
            if(fast==1) return true;
        }while(slow!=fast);
        return false;
    }
    
    public int sum(int n){
        int sum=0;
        while(n>0){
            int digit = n%10;
            sum += digit*digit;
            n = n/10;
        }
        return sum;
    }
}