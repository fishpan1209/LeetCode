public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> temp = new ArrayList();
        combination(res, temp, candidates, target, 0);
        return res;
    }
    
    public void combination(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int start){
        if(target == 0) res.add(new ArrayList(temp));
        
        for(int i= candidates.length-1; i>=0; i--){
            if(candidates[i]>target) continue;
            temp.add(candidates[i]);
            combination(res, temp, candidates, target-candidates[i],i);
            temp.remove(temp.size()-1);
        }
    }
}