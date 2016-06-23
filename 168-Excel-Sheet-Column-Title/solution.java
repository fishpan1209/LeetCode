public class Solution {
    public String convertToTitle(int n) {
        String res = "";
        while(n>0){
            
            char s = (char) ('A'+(n-1)%26);
            n = (n-1) / 26;
            res = s+res;
        }
        
        return res;
    }
}