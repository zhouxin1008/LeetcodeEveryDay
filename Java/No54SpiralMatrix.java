import java.util.ArrayList;

/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */
class No54SpiralMatrix {
    private int i = 0;
    private int j = 0;
    private int direction = 0;
    int m = 0;
    int n = 0;
    boolean[][] mark;
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        m = matrix.length;
        if(m==0) return res;
        n = matrix[0].length;
        int retry = 0;
        mark = new boolean[m][n];
        j = -1;
        while(retry < 4) {  
            boolean moved = tryMove(matrix, res);
            if(moved) retry = 0;
            else {
                retry++;
                getNextDirection();
            }
        }
        return res;
    }

    private boolean canMove(int a, int b) {
        if(a < 0 || a >= m) return false;
        if(b < 0 || b >= n) return false;
        return mark[a][b] == false;
    }

    private boolean tryMove(int[][] matrix, List<Integer> res) {
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
            mark[nextI][nextJ] = true;
            res.add(matrix[nextI][nextJ]);
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

