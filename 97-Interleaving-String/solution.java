public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if((s1.length()==0 || s1==null) && (s2.length()==0 || s2==null)) return (s3.length()==0 || s3==null);
        else if(s1==null || s1.length()==0) return s3.equals(s2);
        else if(s2==null || s2.length()==0) return s3.equals(s1);
        else if(s3.length()!=(s1.length()+s2.length())) return false;
        char c = s3.charAt(0);
        return (s1.charAt(0)==c && isInterleave(s1.substring(1),s2, s3.substring(1))) || (s2.charAt(0)==c && isInterleave(s1, s2.substring(1), s3.substring(1)));
    }
}