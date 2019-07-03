import java.util.Stack;

/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */
class No150EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(String str : tokens){
            Integer num1 = s.isEmpty() ? null : s.pop();
            Integer num2 = s.isEmpty() ? null : s.pop();
            switch (str) {
                case "+":
                    s.push(num1+num2);
                    break;
                case "-":
                    s.push(num2-num1);
                    break;
                case "*":
                    s.push(num1*num2);
                    break;
                case "/":
                    s.push((int)(num2/num1));
                    break;
                default:
                    if(num2!=null) s.push(num2);
                    if(num1!=null) s.push(num1);
                    s.push(Integer.parseInt(str));
                    break;
            }
        }
        return s.pop();
    }
}

