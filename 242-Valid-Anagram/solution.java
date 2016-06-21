public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] ch = new int[26];
        for(int i=0; i<s.length(); i++){
            ch[s.charAt(i)-'a']++;
        }
        for(int j=0; j<t.length(); j++){
            ch[t.charAt(j)-'a']--;
        }
        for(int k=0; k<ch.length; k++){
            if(ch[k]!=0) return false;
        }
        return true;
    }
}