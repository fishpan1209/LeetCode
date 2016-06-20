public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return "";
        if(strs.length==1) return strs[0];
        // vertical scanning, O(S), O(1)
        /*
        // find minlen string first
        int minLen = strs[0].length();
        String minS = strs[0];
        for(String s : strs){
            if(s.length()<minLen){
                minLen = s.length();
                minS = s;
            }
        }
        // must iterate through minS.length() first, otherwise will return whenever a prefix of two string found
        for(int i=0; i<minLen; i++){
            for(String s : strs){
                if(s==minS) continue;
                if(i==s.length() || minS.charAt(i)!=s.charAt(i)) return minS.substring(0,i);
            }
        }
        return minS;
        */
        
        // divide and conquer
        return LCP(strs, 0, strs.length-1);
    }
    
    public String LCP(String[] strs, int start, int end){
        if(start==end) return strs[start];
        else {
            int mid = start+(end-start)/2;
            String left = LCP(strs, start, mid);
            String right = LCP(strs, mid+1, end);
            return commonPrefix(left, right);
        }

    }
    
    public String commonPrefix(String left, String right){
        int min = Math.min(left.length(), right.length());
        for(int i=0; i<min; i++){
            if(left.charAt(i)!=right.charAt(i)) return left.substring(0, i);
        }
        return left.substring(0,min);
    }
}