public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n==1) return 1;
        int[] ugly = new int[n];
        ugly[0] = 1;
        int len = primes.length;
        int[] idx = new int[len];
        int[] factor = new int[len];
        for(int i=0; i<len; i++){
            factor[i] = primes[i];
        }
        for(int i=1; i<n; i++){
            int min = Min(factor);
            ugly[i] = min;
          
            for(int j=0; j<len; j++){
                if(min==factor[j]) {
                    idx[j] +=1;
                    factor[j] = primes[j]*ugly[idx[j]];
                }
            }
        }
        return ugly[n-1];
    }
    
    public int Min(int[] factor){
        int min=Integer.MAX_VALUE;
        for(int i : factor){
            min = Math.min(min, i);
        }
        return min;
    }
}