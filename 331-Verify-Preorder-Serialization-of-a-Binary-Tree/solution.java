public class Solution {
    public boolean isValidSerialization(String preorder) {
        // normal node will have one parent and two childre, diff = 1
        // null node will have one parent and 0 childrenn, diff = -1
        String[] input = preorder.split(",");
        if(input.length>1 && input[0].equals("#")) return false;
        int diff = 1; // root have 2 children;
        for(String s : input){
            if(--diff<0) return false;
            if(!s.equals("#")) diff+=2;
        }
        return diff==0;
    }
}