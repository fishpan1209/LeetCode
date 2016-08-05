public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(wordDict==null || wordDict.size()==0) return false;
        if(s==null || s.length()==0) return true;
        if(s.length()==1) return wordDict.contains(s);
        
            for(int j=1; j<=s.length(); j++){
                String str = s.substring(0, j);
                System.out.println("str: "+str);
                if(wordDict.contains(str)){
                    String rest = s.substring(j, s.length());
                    System.out.println("str: "+str+" rest: "+rest);
                    if(wordBreak(rest, wordDict)) return true;
            
                }
                
            }
        return false;
    }
}