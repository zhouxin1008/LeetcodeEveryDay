import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */
class No84LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length==0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i=0; i<=heights.length; i++) {
            int cur = i == heights.length ? 0 : heights[i];
            if(stack.isEmpty() || cur >= heights[stack.peek()]) {
                stack.push(i);
            }else{
                int last = stack.pop();
                res = Math.max(res, heights[last]*(stack.isEmpty()? i : i-stack.peek()-1));
                i--;
            }
        }
        return res;
    }
}

