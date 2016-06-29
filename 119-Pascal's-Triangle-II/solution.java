public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> allrow = new ArrayList();
        List<Integer> first = new ArrayList();
        first.add(1);
        allrow.add(first);
        for(int i=1; i<=rowIndex; i++){
            List<Integer> prev = allrow.get(i-1);
            List<Integer> cur = new ArrayList();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i) cur.add(1);
                else cur.add(prev.get(j-1)+prev.get(j));
            }
            allrow.add(cur);
        }
        return allrow.get(rowIndex);
    }
}