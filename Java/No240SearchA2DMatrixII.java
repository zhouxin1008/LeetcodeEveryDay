/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */
class No240SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m==0) return false;
        int n = matrix[0].length;
        if(n==0) return false;
        for(int[] row : matrix){
            if(row[0] <= target && row[n-1] >= target){
                inner_loop:
                for(int i=0; i<n; i++){
                    if(row[i] > target) break inner_loop;
                    if(row[i] == target) return true;
                }
            }
        }
        return false;
    }
}

