import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */
class No73SetMatrixZeroes {
    private int m;
    private int n;
    public void setZeroes(int[][] matrix) {
        m = matrix.length;
        if(m==0) return;
        n = matrix[0].length;
        if(n==0) return;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        rows.forEach(num -> this.setRow(num, matrix));
        columns.forEach(num -> this.setColumn(num, matrix));
    }
    private void setRow(int x,int[][] matrix) {
        for(int i=0; i<n; i++){
            matrix[x][i] = 0;
        }
    }
    private void setColumn(int y,int[][] matrix) {
        for(int i=0; i<m; i++){
            matrix[i][y] = 0;
        }
    }
}

