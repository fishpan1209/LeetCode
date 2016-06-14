import java.util.HashSet;
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet();
        Set<String> endSet = new HashSet();
        Set<String> visited = new HashSet();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            // begin set is always smaller
            if(beginSet.size()>endSet.size()){
                Set<String> temp = new HashSet();
                temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            
            // check every word in beginset, replace each char, if in end set, len++
            Set<String> temp = new HashSet();
            for(String word : beginSet){
                char[] ch = word.toCharArray();
                for(int i=0; i<ch.length; i++){
                    for(char c='a'; c<='z'; c++){
                        char old = ch[i];
                        ch[i] = c;
                        String target = String.valueOf(ch);
                        
                        if(endSet.contains(target)){
                            return len+1;
                        }
                        
                        if(!visited.contains(target) && wordList.contains(target)){
                            visited.add(target);
                            temp.add(target);
                        }
                        ch[i] = old;
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }
}