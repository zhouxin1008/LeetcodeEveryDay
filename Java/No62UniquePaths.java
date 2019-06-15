/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */
class No62UniquePaths {
    private int[][] record;
    public int uniquePaths(int m, int n) {
        if(m<=0 || n<=0) return 0;
        record = new int[m][n];
        return findPath(m-1,n-1);
    }

    private int findPath(int i, int j){
        if(i==0 && j==0) return 1;
        if(record[i][j]==0) {
            int a = 0;
            int b = 0;
            if(j!=0) {
                a =  findPath(i, j-1);
            }
            if(i!=0){
                b =  findPath(i-1, j);
            }
            record[i][j] = a + b;
        }
        return record[i][j];
    }
}

