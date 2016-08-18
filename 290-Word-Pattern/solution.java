import java.util.HashMap;
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] p = pattern.toCharArray();
        String[] s = str.trim().split("\\s+");
        if(p.length!=s.length) return false;
        HashMap<Character, String> map1 = new HashMap();
        HashMap<String, Character> map2 = new HashMap();
        for(int i=0; i<p.length; i++){
            if(map1.containsKey(p[i])){
                if(!map1.get(p[i]).equals(s[i])) return false;
            }
            else map1.put(p[i], s[i]);
            if(map2.containsKey(s[i])){
                if(!map2.get(s[i]).equals(p[i])) return false;
            }
            else map2.put(s[i], p[i]);
        }
        
        return true;
    }
}