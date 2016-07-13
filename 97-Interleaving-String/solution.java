public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        char[] ss3 = s3.toCharArray();
        if((ss1.length+ss2.length)!=ss3.length) return false;
        return interleave(ss1, 0, ss2, 0, ss3, 0);
    }
    
    public boolean interleave(char[] s1, int p1, char[] s2, int p2, char[] s3, int p3){
        if((s1.length+s2.length)!=s3.length) return false;
        if(p1==s1.length) return String.valueOf(s2, p2, s2.length).equals(String.valueOf(s3, p3, s3.length));
        if(p2==s2.length) return String.valueOf(s1, p1, s1.length).equals(String.valueOf(s3, p3, s3.length));
        return (s1[p1]==s3[p3++] && interleave(s1, p1+1, s2, p2, s3, p3)) || (s2[p2]==s3[p3++] && interleave(s1, p1, s2, p2+1, s3, p3));
    }
}