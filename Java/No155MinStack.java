/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */
class No155MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(min.isEmpty() || min.peek() > x) {
            min.push(x);
        }else{
            min.push(min.peek());
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            min.pop();
        }
    }
    
    public int top() {
        return stack.isEmpty()? -1 : stack.peek();
    }
    
    public int getMin() {
        return min.isEmpty()? -1 : min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

