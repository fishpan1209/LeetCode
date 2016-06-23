public class Solution {
    public int strStr(String haystack, String needle) {
        if((haystack==null || haystack.length()==0) && (needle==null || needle.length()==0)) return 0;
        else if(haystack==null || needle==null) return -1;
        int len = needle.length();
        for(int i=0; i+len<=haystack.length(); i++){
            System.out.println(haystack.substring(i, i+len));
            if(haystack.substring(i, i+len).equals(needle)) return i;
        }
        return -1;
    }
}