public class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int[] ugly = new int[n];
        int i2=1, i3=1, i5=1;
        int f2=2, f3=3, f5=5;
        for(int i=1; i<n; i++){
            int min = Math.min(Math.min(f2, f3), f5);
            ugly[i] = min;
            if(min==f2){
                f2 = 2*ugly[i2++];
            }
            if(min==f3){
                f3 = 3*ugly[i3++];
            }
            if(min==f5){
                f5 = 5*ugly[i5++];
            }
        }
        
        return ugly[n-1];
    }
}