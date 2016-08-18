public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null || word==null) return false;
        char[] w = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(exist(i, j, board, w, 0)) return true;
            }
        }
        return false;
    }
    
    public boolean exist(int i, int j, char[][]board, char[] w, int pos){
        if(pos==w.length) return true;
        if(i>=board.length || i<0 || j>=board[0].length || j<0) return false;
        if(board[i][j]!=w[pos]) return false;
        // mark board[i][j] as invalid
        // equal to board[i][j]="#";
        board[i][j] ^= 256;  
	    boolean exist = exist(i+1, j, board, w, pos+1)
		                || exist(i-1, j, board, w, pos+1)
		                || exist(i, j+1, board, w, pos+1)
		                || exist(i, j-1, board, w, pos+1);
		// unmark board[i][j]
	    board[i][j] ^= 256;
	    return exist;
        
    }
}