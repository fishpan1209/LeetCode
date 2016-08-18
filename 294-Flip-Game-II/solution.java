public class Solution {
   
    
    public boolean canWin(String s){
        if(s==null || s.length()<2) return false;
        char[] ss = s.toCharArray();
        return canWin(ss);
    }
    
    public boolean canWin(char[] ss){
        int len = ss.length;
        for(int i=0; i<len-1; i++){
            if(ss[i]=='+' && ss[i+1]=='+'){
                ss[i] = '-';
                ss[i+1] = '-';
                boolean win = !canWin(ss);
                ss[i] = '+';
                ss[i+1] = '+';
                if(win) return true;
            }
        }
        return false;
    }
}