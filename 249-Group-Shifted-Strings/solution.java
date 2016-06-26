import java.util.HashMap;
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        if(strings==null || strings.length==0) return new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap();
        for(String s : strings){
            String key = null;
            if(s==null) key = s;
            else{
                char[] ch = s.toCharArray();
                // must record ch[0] first because it will be changed in the loop
                char start = ch[0];
                for(int i=0; i<ch.length; i++){
                   ch[i] = (char) ((ch[i]-start+26)%26+'a');
                }
                key = String.valueOf(ch);
            }
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}