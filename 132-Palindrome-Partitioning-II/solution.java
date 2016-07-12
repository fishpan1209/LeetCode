public class Solution {
    public int minCut(String s) {
        int n = s.length();
        // number of cut after i
        int[] cut = new int[n+1];
        for(int i=0; i<=n; i++){
            cut[i] = i-1;
        }
        for(int i=0; i<n; i++){
            // odd length
            for(int j=0; i-j>=0 && i+j<n && s.charAt(i-j)==s.charAt(i+j); j++){
                cut[i+j+1] = Math.min(cut[i+j+1], cut[i-j]+1);
            }
            
            // even length
            for(int j=1; i-j+1>=0 && i+j<n && s.charAt(i-j+1)==s.charAt(i+j); j++){
                cut[i+j+1] = Math.min(cut[i+j+1], cut[i-j+1]+1);
            }
        }
        return cut[n];
        
    }
}