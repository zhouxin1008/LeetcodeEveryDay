/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */
class No304RangeSumQuery2D {
    private int[][] dp = null;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m==0) return;
        int n = matrix[0].length;
        if(n==0) return;
        dp = new int[m][n];
        for(int i=0; i<m; i++){
            dp[i][0] = matrix[i][0] + (i==0 ? 0 : dp[i-1][0]);
        }
        for(int i=0; i<n; i++){
            dp[0][i] = matrix[0][i] + (i==0 ? 0 : dp[0][i-1]);
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = matrix[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(dp==null) return 0;
        if(row1==0 && col1==0) return dp[row2][col2];
        if(row1==0) return dp[row2][col2] - dp[row2][col1-1];
        if(col1==0) return dp[row2][col2] - dp[row1-1][col2];
        return dp[row2][col2] - dp[row1-1][col2] - dp[row2][col1-1] + dp[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

