public class Solution {
    public int countPrimes(int n) {
        if(n<2) return 0;
        boolean isPrime[] = new boolean[n]; // default value of boolean is false
        for(int i=2; i<n; i++){
            isPrime[i] = true;
        }
        
        for(int i=2; i*i<=n; i++){
            if(!isPrime[i]) continue; // already marked, skip
            for(int j= i*i; j<n; j+=i){ // starting from i^2, mark off all factors
                isPrime[j] = false;
            }
        }
        
        int count=0;
        for(int i=2; i<n; i++){
            if(isPrime[i]) count++;
        }
        return count;
    }
}