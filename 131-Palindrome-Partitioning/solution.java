public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        if(s==null || s.length()==0) return res;
        List<String> cur = new ArrayList();
        dfs(s,0,cur, res);
        return res;
    }
    
    public void dfs(String s, int pos, List<String> cur, List<List<String>> res){
        if(pos==s.length()) res.add(new ArrayList<String>(cur));
        else{
            for(int i=pos;i<s.length();i++){
                if(isPalindrome(s,pos,i)){
                    cur.add(s.substring(pos,i+1));
                    dfs(s,i+1,cur,res);
                    cur.remove(cur.size()-1);
                }
            }
        }
        
    }
    
    public boolean isPalindrome(String s, int low, int high){
        while(low<high) if(s.charAt(low++)!=s.charAt(high--)) return false;
        return true;
    }
}