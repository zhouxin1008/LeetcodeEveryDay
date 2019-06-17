/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */
class No74SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m==0) return false;
        int n = matrix[0].length;
        if(n==0) return false;
        int i=0, j=0;
        while(i<m && j<n){
            if(matrix[i][j] != target){
                if(i!=m-1 && matrix[i+1][j] <= target){
                    i++;
                }else{
                    j++;
                }
                continue;
            }
            return true;
        }
        return false;
    }
}

