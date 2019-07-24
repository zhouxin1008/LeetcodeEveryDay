/*
 * @lc app=leetcode id=329 lang=java
 *
 * [329] Longest Increasing Path in a Matrix
 */
class No329LongestIncreasingPathIn_A_Matrix {
    private int m;
    private int n;
    private int max;
    private int memory[][];
    private int matrix[][];
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        if(m==0) return 0;
        n = matrix[0].length;
        if(n==0) return 0;
        this.matrix = matrix;
        memory = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dfs(i, j);
            }
        }
        return max;
    }
    private int dfs(int i, int j){
        if(memory[i][j]!=0) return memory[i][j];
        int right = j==n-1 || matrix[i][j] <= matrix[i][j+1] ? 0 : dfs(i, j+1);
        int down = i==m-1 || matrix[i][j] <= matrix[i+1][j] ? 0 : dfs(i+1, j);
        int left = j==0 || matrix[i][j] <= matrix[i][j-1] ? 0 : dfs(i, j-1);
        int up = i==0 || matrix[i][j] <= matrix[i-1][j] ? 0 : dfs(i-1, j);
        memory[i][j] = Math.max(Math.max(right, down), Math.max(left,up)) + 1;
        max = Math.max(max, memory[i][j]);
        return memory[i][j];
    }
}

