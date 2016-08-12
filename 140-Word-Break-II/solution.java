public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if(s==null || wordDict==null) return res;
        // use a map to store start word and corresponding list
        Map<String, List<String>> map = new HashMap();
        return wordBreak(s, wordDict, map);
    }
    
    public List<String> wordBreak(String s, Set<String> wordDict, Map<String, List<String>> map){
        // if this string is already checked, return list
        if(map.containsKey(s)) return map.get(s);
        // otherwise, initiate a new list, if the string is in dict, add it to list
        List<String> res = new ArrayList<String>();
        if(wordDict.contains(s)) res.add(s);
        for(int i=1; i<s.length(); i++){
            String left = s.substring(0,i);
            String right = s.substring(i);
            // check if the remain right string first
            if(wordDict.contains(left) && containsSuffix(right, wordDict)){
                List<String> remain = wordBreak(right, wordDict, map);
                for(String str : remain) {
                    res.add(left+" "+str);
                }
            }
        }
        map.put(s, res);
        return res;
    }
    
    public boolean containsSuffix(String s, Set<String> wordDict){
        for(String w : wordDict){
            if(s.startsWith(w)) return true;
        }
        return false;
    }
}