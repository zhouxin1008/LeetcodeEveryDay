/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */
class No48RotateImage {
    private int p = 0;
    private int q = 0;
    private int direction = 0;
    private int upperEdge = 0;
    private int lowerEdge = 0;
    public void rotate(int[][] matrix) {
        int len = matrix[0].length;
        for(int i=0; i<len/2; i++) {
            lowerEdge = i;
            upperEdge = len-i-1;
            int j = i;
            while (j<upperEdge){
                p = i;
                q = j;
                int temp = matrix[i][j];
                int count = 4;
                while(count > 0) {
                    temp = updateNext(matrix, temp);
                    count--;
                }
                j++;
            }
        }
    }

    private int updateNext(int[][] nums, int temp) {
        int steps = upperEdge - lowerEdge;
        while(steps>0) {
            move();
            steps--;
        }
        int res = nums[p][q];
        nums[p][q] = temp;
        return res;
    }
    
    private void move() {
        switch (direction) {
            case 0:
                if(q < upperEdge){
                    q++;
                }
                else{
                    updateDirection();
                    move();
                }
                break;
            case 1:
                if(p < upperEdge){
                    p++;
                }
                else{
                    updateDirection();
                    move();
                }
                break;
            case 2:
                if(q > lowerEdge){
                    q--;
                }
                else{
                    updateDirection();
                    move();
                }
                break;
            case 3:
                if(p > lowerEdge){
                    p--;
                }
                else{
                    updateDirection();
                    move();
                }
                break;
            default:
                break;
        }
    }

    private void updateDirection() {
        // 0 right
        // 1 down
        // 2 left
        // 3 up
        direction = (direction+1) % 4;
    }
}

