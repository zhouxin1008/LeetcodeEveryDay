/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */
class No63UniquePaths2 {
    private int[][] mark;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0) return 0;
        int n = obstacleGrid[0].length;
        if(n == 0) return 0;
        mark = new int[m][n];
        mark[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        return findPath(m-1, n-1, obstacleGrid);
    }
    private int findPath(int i, int j, int[][] obstacleGrid){
        if(mark[i][j]==0 && obstacleGrid[i][j]!=1) {
            int a = 0;
            int b = 0;
            if(j!=0) {
                a =  findPath(i, j-1, obstacleGrid);
            }
            if(i!=0){
                b =  findPath(i-1, j, obstacleGrid);
            }
            mark[i][j] = a + b;
        }
        return mark[i][j];
    }
}

