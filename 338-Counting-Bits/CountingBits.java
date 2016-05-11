public class Solution {
    public int[] countBits(int num) {
        // if i&(i-1)==0, then i is power of 2
        // if i is power of 2, the number of 1 of previous result + 1
        int[] res = new int[num+1];
        res[0] = 0;
        for(int i=1; i<num+1;i++){
            res[i] = res[i & (i-1)]+1;
        }
        return res;
    }
}
