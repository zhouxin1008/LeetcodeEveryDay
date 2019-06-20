import java.util.Stack;

/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */
class No85MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m==0) return 0;
        int n = matrix[0].length;
        if(n==0) return 0;
        int[][] heights = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0){
                    heights[i][j] = matrix[i][j] - '0';
                }else{
                    heights[i][j] = matrix[i][j] == '0' ? 0 : 1 + heights[i-1][j];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            res = Math.max(res, singleRowMaximalRectangle(heights[i]));
        }
        return res;
    }

    private int singleRowMaximalRectangle(int[] h) {
        Stack<Integer> s = new Stack<>();
        int res = 0;
        for(int i=0; i<=h.length; i++){
            int cur = i==h.length ? 0 : h[i];
            if(s.isEmpty() || cur>h[s.peek()]){
                s.push(i);
            }else{
                int last = s.pop();
                res = Math.max(res, h[last]*(s.isEmpty() ? i : i - s.peek() - 1));
                i--;
            }
        }
        System.out.println(res);
        return res;
    }
}

