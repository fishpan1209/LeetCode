public class Solution {
    public String reverseWords(String s) {
        if(s==" " || s.length()==0) return s;
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=words.length-1; i>=0; i--){
            sb.append(words[i]+" ");
        }
        // trim to remove leading or tailing spaces
        return sb.toString().trim();
    }
}