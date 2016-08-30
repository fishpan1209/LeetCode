public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length()==0) return word2.length();
        if(word2.length()==0) return word1.length();
        
        int len1 = word1.length();
        int len2 = word2.length();
        
        int[][] distance = new int[len1+1][len2+1];
        
        // if add a char to word1
        for(int i=0; i<=len1; i++){
            distance[i][0] = i;
        }
        
        // if delete a char from word2
        for(int j=0; j<=len2; j++){
            distance[0][j] = j;
        }
        
        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                if(word1.charAt(i-1) == word2.charAt(i-1)){
                    distance[i][j] = distance[i-1][j-1];
                }
                else{
                    distance[i][j] = Math.min(Math.min(distance[i-1][j], distance[i][j-1]),distance[i-1][j-1])+1;
                }
            }
        }
        
        return distance[len1][len2];
        
    }
}