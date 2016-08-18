public class Solution {
    public String getHint(String secret, String guess) {
        if(secret==null) return null;
        int bull=0;
        int cow=0;
        HashMap<Character, Integer> map = new HashMap();
        for(int i=0; i<secret.length();i++){
            char c = secret.charAt(i);
            char g = guess.charAt(i);
            if(c==g) bull++;
            else{
                if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else map.put(c,  1);
            }
        }
        for(int j=0; j<guess.length(); j++){
            char c = secret.charAt(j);
            char g = guess.charAt(j);
            if(c==g) continue;
          
            if(map.containsKey(g) && map.get(g)>0){
                cow++;
                map.put(g, map.get(g)-1);
            }
        }
           
        return (bull+"A"+cow+"B");
    }
}