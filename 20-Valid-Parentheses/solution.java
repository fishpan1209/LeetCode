public class Solution {
    public boolean isValid(String s) {
        if(s==null) return true;
        char[] ch = s.toCharArray();
        if(ch.length%2 != 0) return false;
        Stack<Character> stack = new Stack();
        for(char c : ch){
            if(c=='(' || c=='[' || c=='{') stack.push(c);
            else{
                
                if(!stack.isEmpty()){
                    char left = stack.pop();
                    if(left=='(' && c!=')') return false;
                    if(left=='[' && c!=']') return false;
                    if(left=='{' && c!='}') return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;
        else return true;
    }
}