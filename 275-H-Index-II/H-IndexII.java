public class Solution {
    public int hIndex(int[] citations) {
        int L = citations.length;
        if(L<1) return 0;
        int start = 0, end = L-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(citations[mid] == L-mid) return L-mid;
            else if(citations[mid] > L-mid) end = mid-1;
            else start = mid+1;
        }
        return L-end-1;
    }
}