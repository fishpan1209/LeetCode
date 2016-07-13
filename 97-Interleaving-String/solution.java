public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if((s1.length()+s2.length())!=s3.length()) return false;
        return interleave(s1, 0, s2, 0, s3, 0);
    }
    
    public boolean interleave(String s1, int p1, String s2, int p2, String s3, int p3){
        
        if(p1==s1.length()) return s2.substring(p2).equals(s3.substring(p3));
        if(p2==s2.length()) return s1.substring(p1).equals(s3.substring(p3));
        return (s1.charAt(p1)==s3.charAt(p3) && interleave(s1, p1+1, s2, p2, s3, p3+1)) || (s2.charAt(p2)==s3.charAt(p3) && interleave(s1, p1, s2, p2+1, s3, p3+1));
    }
}