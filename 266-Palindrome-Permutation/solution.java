import java.util.HashMap;
public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s==null || s.length()<=1) return true;
        char[] ch = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap();
        for(int i=0; i<ch.length; i++){
            char c = ch[i];
            if(map.containsKey(c)) map.remove(c);
            else map.put(c, i);
        }
        if(map.size()<=1) return true;
        else return false;
    }
}