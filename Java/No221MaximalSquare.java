/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */
class No221MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m==0) return 0;
        int n = matrix[0].length;
        if(n==0) return 0;
        int res = 0;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
                res = 1;
            }
        }
        for(int i=0; i<n; i++){
            if(matrix[0][i] == '1'){
                dp[0][i] = 1;
                res = 1;
            }
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                int temp;
                if(matrix[i][j]=='1'){
                    temp = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }else{
                    temp = 0;
                }
                res = Math.max(res, temp);
                dp[i][j] = temp;
            }
        }
        return res*res;
    }
}

