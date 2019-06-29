/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */
class No130SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length;
        if(m==0) return;
        int n = board[0].length;
        if(n==0) return;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]!='O') continue;
                if(i!=0&&i!=m-1&&j!=0&&j!=n-1) continue;
                dfs(board, i, j, m, n);
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]!='T') board[i][j] = 'X';
                else board[i][j] = 'O';
            }
        }
    }
    private void dfs(char[][] board, int i, int j, int m, int n) {
        if(i<0 || i>=m || j<0 || j>=n) return;
        if(board[i][j] == 'T' || board[i][j] == 'X') return;
        board[i][j] = 'T';
        dfs(board, i+1, j, m, n);
        dfs(board, i-1, j, m, n);
        dfs(board, i, j+1, m, n);
        dfs(board, i, j-1, m, n);
    }
}

