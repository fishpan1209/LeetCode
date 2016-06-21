public class Solution {
    public String reverseWords(String s) {
        if(s==null || s.length()==0) return s;
        String[] words = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        for(int i=words.length-1; i>=0; i--){
            res.append(words[i]+" ");
        }
        return res.toString().trim();
    }
}