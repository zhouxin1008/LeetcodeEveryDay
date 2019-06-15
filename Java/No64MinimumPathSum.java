/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */
class No64MinimumPathSum {
    private Integer[][] mark;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m==0) return 0;
        int n = grid[0].length;
        if(n==0) return 0;
        mark = new Integer[m][n];
        mark[0][0] = grid[0][0];
        return findPath(m-1, n-1, grid);
    }

    private int findPath(int i, int j, int[][] grid) {
        if(mark[i][j] == null) {
            int minSum = Integer.MAX_VALUE;
            if(i!=0) minSum = Math.min(minSum, findPath(i-1,j,grid));
            if(j!=0) minSum = Math.min(minSum, findPath(i,j-1,grid));
            mark[i][j] = grid[i][j] + minSum;
        }
        return mark[i][j];
    } 
}

