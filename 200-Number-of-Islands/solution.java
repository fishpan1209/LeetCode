public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m==0 || grid==null) return 0;
        int n = grid[0].length;
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // if an island found, count++; set all connecting land to 0
                if(grid[i][j]=='1'){
                    drown(grid,i,j, m, n );
                    count++;
                }
            }
        }
        return count;
    }
    
    public void drown(char[][] grid, int i, int j, int m, int n){
        if(i>=m || i<0 || j>=n || j<0 || grid[i][j]!='1') return;
        grid[i][j]='0';
        drown(grid, i+1, j, m, n);
        drown(grid, i-1, j, m, n);
        drown(grid, i, j+1, m, n);
        drown(grid, i, j-1, m, n);
    }
}