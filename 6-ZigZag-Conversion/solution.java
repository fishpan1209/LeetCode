public class Solution {
    public String convert(String s, int numRows) {
        if(s==null || s.length()==0) return s;
        char[] str = s.toCharArray();
        int len = str.length;
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++){ // vertically down
                sb[idx].append(str[i++]);
            }
            for (int idx = numRows-2; idx >= 1 && i < len; idx--){ // obliquely up
                sb[idx].append(str[i++]);
            }
       }
       for (int idx = 1; idx < sb.length; idx++)  sb[0].append(sb[idx]);
       return sb[0].toString();
        
    }
}