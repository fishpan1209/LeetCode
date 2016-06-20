public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return "";
        if(strs.length==1) return strs[0];
        // vertical scanning, O(S), O(1)
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
    }
}