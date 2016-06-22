public class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    drown(grid, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void drown(char[][] grid, int i, int j, int m, int n){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]!='1') return;
        grid[i][j] = '0';
        drown(grid, i+1, j, m, n);
        drown(grid, i-1, j, m, n);
        drown(grid, i, j+1, m, n);
        drown(grid, i, j-1, m, n);
    }
}