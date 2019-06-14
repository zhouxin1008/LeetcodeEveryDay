/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */
class No59SpiralMatrix2 {
    private int i = 0;
    private int j = -1;
    private int direction = 0;
    private int n = 0;
    private boolean[][] mark;
    private int[][] res;
    private int count = 1;
    public int[][] generateMatrix(int n) {
        if(n<=0) return new int[0][];
        int retry = 0;
        mark = new boolean[n][n];
        res = new int[n][n];
        this.n = n;
        while(retry < 4) {  
            boolean moved = tryMove();
            if(moved) retry = 0;
            else {
                retry++;
                getNextDirection();
            }
        }
        return res;
    }

    private boolean canMove(int a, int b) {
        if(a < 0 || a >= n) return false;
        if(b < 0 || b >= n) return false;
        return mark[a][b] == false;
    }

    private boolean tryMove() {
        int nextI = i;
        int nextJ = j;
        switch (direction) {
            case 0:
                nextJ++;
                break;
            case 1:
                nextI++;
                break;
            case 2:
                nextJ--;
                break;
            case 3:
                nextI--;
                break;
        }
        if(canMove(nextI, nextJ)) {
            res[nextI][nextJ] = count++;
            mark[nextI][nextJ] = true;
            i = nextI;
            j = nextJ;
            return true;
        } else {
            return false;
        }
    }

    private int getNextDirection() {
        return direction = (direction+1) % 4;
    }
}

