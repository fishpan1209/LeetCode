public class Solution {
    public int hIndex(int[] citations) {
        int L = citations.length;
        if(L<1) return 0;
        int[] counts = new int[L+1];
        // if citation is larger than L, then put the total number in count[L] because h can be no larger than L
        for(int i : citations) {
            if(i>L) counts[L]++;
            else counts[i]++;
        }
        int res = 0;
        for(int k=L; k>=0; k--) {
           res += counts[k];
           if(res>=k) return k;
        }
       return 0;
        
    }
}