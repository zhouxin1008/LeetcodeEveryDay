/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */
class No200NumberOfIslands {
    private int m;
    private int n;
    public int numIslands(char[][] grid) {
        this.m = grid.length;
        if(this.m==0) return 0;
        this.n = grid[0].length;
        if(this.n==0) return 0;
        int res = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid, int i, int j) {
        if(i<0 || i>=m || j<0 || j>=n) return;
        if(grid[i][j] != '1') return;
        grid[i][j] = '2';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}

