public class Solution {
    private int lo;
    private int max;
    public String longestPalindrome(String s) {
        if(s==null || s.length()<=1) return s;
        char[] str = s.toCharArray();
        for(int i=0; i<s.length()-1; i++){
            palindrome(str,i, i ); //odd len
            palindrome(str, i, i+1); // even len
        }
        return s.substring(lo, lo+max);
    }
    
    public void palindrome(char[] str, int start, int end){
        while(start>=0 && end<=str.length-1 && str[start]==str[end]){
            start--;
            end++;
        }
        if(max<end-start-1){
            lo = start+1;
            max = end-start-1;
        }
    }
}