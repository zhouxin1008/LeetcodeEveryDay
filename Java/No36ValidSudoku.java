/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */
class No36ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++) {
            boolean temp = checkColumn(board,i,9) && checkRow(board,i,9);
            if(!temp) return false;
        }
        for(int i=0; i<9; i+=3) {
            for(int j=0; j<9; j+=3) {
                if(!checkSubCube(board,i,j,3)) return false;
            }
        }
        return true;
    }
    private boolean checkColumn(char[][] board, int col, int len) {
        boolean[] mark = new boolean[10];
        for(int i=0; i<len; i++){
            char c = board[i][col];
            if(c == '.') continue;
            if(mark[c-'0']) return false;
            else mark[c-'0'] = true;
        }
        return true;
    }

    private boolean checkRow(char[][] board, int row, int len) {
        boolean[] mark = new boolean[10];
        for(int i=0; i<len; i++){
            char c = board[row][i];
            if(c == '.') continue;
            if(mark[c-'0']) return false;
            else mark[c-'0'] = true;
        }
        return true;
    }

    private boolean checkSubCube(char[][] board, int row, int col, int len) {
        boolean[] mark = new boolean[10];
        for(int i=row; i<row+len; i++){
            for(int j=col; j<col+len; j++){
                char c = board[i][j];
                if(c == '.') continue;
                if(mark[c-'0']) return false;
                else mark[c-'0'] = true;
            }
        }
        return true;
    }
}

