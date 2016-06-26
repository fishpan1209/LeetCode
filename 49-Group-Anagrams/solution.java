import java.util.HashMap;
public class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs){
        if(strs==null || strs.length==0) return new ArrayList<List<String>>();
        // sort key string s, put all anagrams to list as values
        HashMap<String, List<String>> map = new HashMap();
        
        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            // if s not in map yet, use sorted string as key
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            // add all anagrams to list
            map.get(key).add(s);
        }
        
        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }
        
        return new ArrayList<List<String>>(map.values());
    }
    // time limit exceeded
    /*
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        int n = strs.length;
        if(strs==null || n==0) return res;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            List<String> cur = new ArrayList<String>();
            cur.add(strs[i]);
            for(int j=i+1; j<n; j++){
                if(isAnagrams(strs[i], strs[j])){
                    visited[j] = true;
                    cur.add(strs[j]);
                }
            }
            res.add(cur);
        }
        return res;
    }
    
    public boolean isAnagrams(String a, String b){
        
        if(a.length()!=b.length()) return false;
        int[] count = new int[26];
        for(int i=0; i<a.length(); i++){
            count[a.charAt(i)-'a']++;
            count[b.charAt(i)-'a']--;
        }
        // check i from 0 to 26, not a.length()!
        for(int i=0; i<26; i++){
            
            if(count[i]!=0) {
                return false;
            }
        }
     
        return true;
    }
    */
}