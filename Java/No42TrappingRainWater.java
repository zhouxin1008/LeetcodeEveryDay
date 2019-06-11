import java.util.Queue;
import java.util.Stack;

/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */
class No42TrappingRainWater {
    public int trap(int[] height) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int sum = 0;
        for(int n : height) {
            if(!q.isEmpty() && n >= q.peek()) {
                int peek = q.peek();
                while(!q.isEmpty()){
                    sum += (peek - q.poll());
                }
            }
            q.offer(n);
        }
        if(!q.isEmpty()) {
            Stack<Integer> s = new Stack<>();
            while(!q.isEmpty()) {
                s.push(q.poll());
            }
            while(!s.isEmpty()) {
                int n = s.pop();
                if(!q.isEmpty() && n >= q.peek()) {
                    int peek = q.peek();
                    while(!q.isEmpty()){
                        sum += (peek - q.poll());
                    }
                }
                q.offer(n);
            }
        }
        return sum;
    }

    public int trap2(int[] A){
        int a=0;
        int b=A.length-1;
        int max=0;
        int leftmax=0;
        int rightmax=0;
        while(a<=b){
            leftmax=Math.max(leftmax,A[a]);
            rightmax=Math.max(rightmax,A[b]);
            if(leftmax<rightmax){
                max+=(leftmax-A[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                a++;
            }
            else{
                max+=(rightmax-A[b]);
                b--;
            }
        }
        return max;
    }
}

