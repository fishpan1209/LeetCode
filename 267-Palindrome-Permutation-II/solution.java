public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList();
        if(s==null) return res;
        int[] count = new int[256];
        int n = s.length();
        for(int i=0; i<n; i++){
            count[s.charAt(i)]++;
        }
        int mid=0;
        int m = 0; // count number of odd char
        for(int i=0; i<256; i++){
            if(m==0 && count[i]%2==1){
                mid = i;
                m++;
            }
            else if(count[i]%2==1){
                return res;
            }
        }
        
        String cur = "";
        if(mid!=0){
            cur += (char)mid;
            count[mid]--;
        }
       
        dfs(count, res, cur, n);
        return res;
    }
    
    public void dfs(int[] count, List<String> res, String cur, int n){
        if(cur.length()==n){
            res.add(new String(cur));
            return;
        }
        for(int i=0; i<count.length; i++){
            if(count[i]<=0) continue;
            count[i] -= 2;    // 2 char used
            cur = (char)i+cur+(char)i;
            dfs(count, res, cur, n);
            cur = cur.substring(1, cur.length()-1);
            count[i] += 2;
        }
    }
}