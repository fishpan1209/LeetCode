public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        combination(k,n,res, temp,1);
        return res;
    }
    
    public void combination(int k, int n, List<List<Integer>> res, List<Integer> temp, int start){
        if(temp.size()==k && n==0){
            res.add(new ArrayList(temp));
            return;
        }
        for(int j=start; j<=9; j++){
            temp.add(j);
            combination(k, n-j, res, temp, j+1);
            temp.remove(temp.size()-1);
        }
    }
}