public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> temp = new ArrayList();
        combine(res, temp, 1, n, k);
        return res;
    }
    
    public void combine(List<List<Integer>> res , List<Integer> temp, int start, int end, int k){
        if(k==0) {
            res.add(new ArrayList(temp));
            return;
        }
        
        for(int i=start; i<=end; i++){
            temp.add(i);
            System.out.println("added: "+i);
            combine(res, temp, i+1, end, k-1);
            //System.out.println("removed: "+temp.get(temp.size()-1));
            // remove the last one added, then add another 
            // eg, [1,2]->remove 2->add 3->[1,3]
            temp.remove(temp.size()-1);
        }
    }
}