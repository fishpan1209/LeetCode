public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList();
        if(matrix==null || matrix.length==0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        int rowS=0, rowE=m-1;
        int colS=0, colE=n-1;
        
        while(rowS<=rowE && colS<=colE){
            // add top row
            for(int i=colS; i<=colE; i++) res.add(matrix[rowS][i]);
            rowS++;
            // add right col
            for(int i=rowS; i<=rowE; i++) res.add(matrix[i][colE]);
            colE--;
            // add bottom row
            if(rowS<=rowE){
            for(int i=colE; i>=colS; i--) res.add(matrix[rowE][i]);
            rowE--;
            }
            // add left col
            if(colS<=colE){
            for(int i=rowE; i>=rowS; i--) res.add(matrix[i][colS]);
            colS++;
            }
        }
        return res;
        
    }
}
