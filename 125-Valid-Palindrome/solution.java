public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null || s.length()==0) return true;
        char[] str = s.trim().replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();
        int l=0;
        int r=str.length-1;
        while(l<r){
            if(str[l]==' ') l++;
            if(str[r]==' ') r--;
            if(str[l]!=str[r]) return false;
            else{
                l++;
                r--;
            }
        }
        return true;
        
    }
}