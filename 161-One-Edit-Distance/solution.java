public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if(Math.abs(sl-tl)>=2) return false;
        
        // three scenerios: 
        // equal length: abc vs adc
        // 1 char in length: ab vs abc   || acb vs ab
        
        String ll = sl>tl? s : t;
        String ss = sl>tl? t : s;
        for(int i=0; i<ss.length(); i++){
            if(ss.charAt(i)!=ll.charAt(i)){
                if(sl==tl) return ss.substring(i+1, sl).equals(ll.substring(i+1,sl));
                else return ll.substring(i+1, ll.length()).equals(ss.substring(i, ss.length()));
            }
        }
        return ll.length()-ss.length()==1;
    }
}