/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */
class No37SudokuSolver {
    int[][] row = new int[9][9];
    int[][] col = new int[9][9];
    int[][] box = new int[9][9];
    char[][] b;
    boolean solved = false;
    private int getBox(int x, int y) {
        return x/3*3 + y/3;
    }
    public void solveSudoku(char[][] board) {
        b = board;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(b[i][j] != '.'){
                    int num = (b[i][j] - '0') - 1;
                    row[i][num] = 1;
                    col[j][num] = 1;
                    box[getBox(i, j)][num] = 1;
                }
            }
        }
        dfs(0, 0);
    }
    private void dfs(int x, int y) {
        if(solved) return;
        if(x == 9) {
            solved = true;
            return;
        }
        int ny = (y + 1) % 9;
        int nx = ny == 0 ? x + 1 : x;
        if (b[x][y] != '.') {
            dfs(nx, ny);
            return;
        }
        for(int i=0; i<9 && !solved; i++) {
            if(row[x][i]==1 || col[y][i]==1 || box[getBox(x, y)][i]==1) continue;
            row[x][i] = 1;
            col[y][i] = 1;
            box[getBox(x, y)][i] = 1;
            b[x][y] = (char)(i + '1');
            dfs(nx, ny);
            if(!solved) {
                b[x][y] = '.';
                row[x][i] = 0;
                col[y][i] = 0;
                box[getBox(x, y)][i] = 0;
            }
        }
    }
}

