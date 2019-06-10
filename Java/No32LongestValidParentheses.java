/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */
class No32LongestValidParentheses {
    // DP
    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len < 2) return 0;
        int max = 0;
        char[] array = s.toCharArray();
        int[] longest = new int[len];
        for(int i=1; i<len; i++) {
            if(array[i]==')' && i-longest[i-1]-1 >=0 && array[i-longest[i-1]-1]=='('){
                int index = i-longest[i-1]-2;
                longest[i] = 2 + longest[i-1] + (index>=0?longest[index]:0);
                max = Math.max(max, longest[i]);
            }
        }
        return max;
    }
    // STACK
    public int longestValidParentheses2(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int result = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                result = Math.max(result, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return result;
    }
    // hit time limit
    public int longestValidParentheses3(String s) {
        int len = s.length();
        if(len < 2) return 0;
        int max = 0;
        char[] array = s.toCharArray();
        boolean[][] mark = new boolean[len][len];
        for(int i=1; i<len; i+=2) {
            for(int j=0; j+i<len; j++){
                if (i==1) {
                    mark[j][j+i] = array[j]=='(' && array[j+i] == ')';
                } else {
                    mark[j][j+i] = array[j]=='(' && array[j+i] == ')' && mark[j+1][j+i-1];
                    int k = 1;
                    while(!mark[j][j+i] && k < i) {
                        mark[j][j+i] = mark[j][j+k] && mark[j+k+1][j+i];
                        k+=2;
                    }
                }
                if(mark[j][j+i]) {
                    max = Math.max(i+1, max);
                }
            }
        }
        return max;
    }
}

