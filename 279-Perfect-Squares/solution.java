public class Solution {
    public int numSquares(int n) {
        List<Integer> res = new ArrayList();
        if(res.size()==0) res.add(0);
        while(res.size()<=n){
            int m = res.size();
            int min = Integer.MAX_VALUE;
            for(int j=1; j*j<=m; j++){
                min = Math.min(min, res.get(m-j*j)+1);
            }
            res.add(min);
        }
        return res.get(n);
    }
}