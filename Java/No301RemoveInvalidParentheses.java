import java.util.ArrayList;

/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 */
class No301RemoveInvalidParentheses {
    int lp = 0; //left parentheses
    int rp = 0; //right parentheses
    char[] str;
    List<String> res;
    public List<String> removeInvalidParentheses(String s) {
        str = s.toCharArray();
        res = new ArrayList<>();
        count();
        dfs(0, lp, rp);
        return res;
    }
    private void dfs(int start, int l, int r) {
        if(l==0 && r==0) {
            if(isValid()) addToRes();
            return;
        }
        if(start == str.length) return;
        if(r > 0) {
            for(int i=start; i<str.length; i++) {
                if (str[i] == ')' && (i==start || str[i]!=str[i-1])){
                    str[i] = '#';
                    dfs(i+1, l, r-1);
                    str[i] = ')';
                }
            }
        } else {
            for(int i=start; i<str.length; i++) {
                if (str[i] == '(' && (i==start || str[i]!=str[i-1])){
                    str[i] = '#';
                    dfs(i+1, l-1, r);
                    str[i] = '(';
                }
            }
        }
    }
    private boolean isValid() {
        int l = 0;
        for(char c: str) {
            if(c == '(') l++;
            if(c == ')') l--;
            if(l < 0) return false;
        }
        return l == 0;
    }
    private void count() {
        for(char c: str) {
            if(c == ')' && lp > 0) lp--;
            else if(c == ')' && lp == 0) rp++;
            else if(c == '(') lp++;
        }
    }
    private void addToRes() {
        StringBuilder sb = new StringBuilder();
        for(char c : str) {
            if (c != '#') {
                sb.append(c);
            }
        }
        res.add(sb.toString());
    }
}

