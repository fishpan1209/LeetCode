public class Solution {
    public void reverseWords(char[] s) {
        // reverse the whole string first, then reverse each word
        if(s==null || s.length==0) return;
        reverse(s, 0, s.length-1);
        int start=0;
        for(int i=0; i<s.length; i++){
            if(s[i]==' '){
                reverse(s, start, i-1);
                start = i+1;
            }
        }
        // still need to reverse last word
        reverse(s, start, s.length-1);
    }
    
    public void reverse(char[] s, int start, int end){
        while(start<end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
