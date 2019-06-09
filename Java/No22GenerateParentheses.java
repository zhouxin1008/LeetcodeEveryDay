/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */
class No22GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        return generateParenthesis("", n, n);
    }
    private List<String> generateParenthesis(String s, int left, int right) {
        List<String> res = new ArrayList<>();
        if(left==0 && right==0){
            res.add(s);
        }
        if (left > 0) {
            res.addAll(generateParenthesis(s+"(", left-1, right));
        }
        if (right > left) {
            res.addAll(generateParenthesis(s+")", left, right-1));
        }
        return res;
    }
}

