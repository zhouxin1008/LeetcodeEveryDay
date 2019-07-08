/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 */
class No174DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = Math.max(1-dungeon[m-1][n-1], 1);
        for(int i = n-2; i>=0; i--){
            dp[m-1][i] = Math.max(dp[m-1][i+1] - dungeon[m-1][i], 1);
        }
        for(int i = m-2; i>=0; i--){
            dp[i][n-1] = Math.max(dp[i+1][n-1] - dungeon[i][n-1], 1);
        }
        for(int i=m-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                dp[i][j] = Math.min(Math.max(dp[i][j+1] - dungeon[i][j], 1), 
                Math.max(dp[i+1][j] - dungeon[i][j], 1));
            }
        }
        return dp[0][0];
    }
}

