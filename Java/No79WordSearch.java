/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */
class No79WordSearch {
    char[] chars;
    char[][] board;
    boolean[][] footPrint;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return true;
        m = board.length;
        if(m==0) return false;
        n = board[0].length;
        if(n==0) return false;
        this.chars = word.toCharArray();
        this.board = board;
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                footPrint = new boolean[m][n];
                if(dfs(i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index){
        if(index == chars.length) return true;
        if(i<0 || i>=m) return false;
        if(j<0 || j>=n) return false;
        if(footPrint[i][j] == true) return false;
        if(board[i][j] != chars[index]) return false;
        footPrint[i][j] = true;
        boolean res = dfs(i+1, j, index+1) || dfs(i-1, j, index+1) || dfs(i, j+1, index+1) || dfs(i, j-1, index+1);
        footPrint[i][j] = false;
        return res;
    }
}

