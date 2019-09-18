/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */
class No695MaxAreaOfIsland {
    int[][] g;
    int m,n;
    public int maxAreaOfIsland(int[][] grid) {
        g = grid;
        m = g.length;
        if (m==0) return 0;
        n = g[0].length;
        if (n==0) return 0;
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(g[i][j] == 1){
                    count = Math.max(count,dfs(i, j));
                }
            }
        }
        return count;
    }
    private int dfs(int x, int y) {
        if(x<0 || x>=m || y<0 || y>=n) return 0;
        if(g[x][y] != 1) return 0;
        g[x][y] = 2;
        return 1 + dfs(x+1, y)
            + dfs(x-1, y)
            + dfs(x, y-1)
            + dfs(x, y+1);
    }
}

