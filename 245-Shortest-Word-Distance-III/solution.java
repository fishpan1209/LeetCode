public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int min = words.length;
        int p2=-1;

        for(int p1=0; p1<words.length; p1++){
            if(words[p1].equals(word1) || words[p1].equals(word2)){
                if(p2!=-1 && (word1.equals(word2) || !words[p1].equals(words[p2]))){
                    min = Math.min(min, Math.abs(p1-p2));
                }
                p2 = p1;
            } 
            
        }
        return min;
    }
}
