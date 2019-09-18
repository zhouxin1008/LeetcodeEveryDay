/*
 * @lc app=leetcode id=282 lang=java
 *
 * [282] Expression Add Operators
 */
class Solution {
    private int[] num;
    private char[] ops;
    private List<String> res;
    private int tar;
    public List<String> addOperators(String num, int target) {
        this.res = new ArrayList<>();
        if(num.length() == 0) return this.res;
        this.num = new int[num.length()];
        for(int i=0; i<num.length(); i++){
            this.num[i] = num.charAt(i)-'0';
        }
        this.tar = target;
        this.ops = new char[num.length()-1];
        dfs(0, 0, 0);
        return res;
    }
    private void dfs(int start, int pre, int total) {
        if(start == num.length) {
            if(total == tar) addToRes();
            return;
        }
        int origin = start;
        int cur = 0;
        while(start < num.length) {
            if(num[origin]==0 && start > origin) break;
            cur = cur*10 + num[start];
            if(start!=origin) ops[start-2] = ' ';
            ops[start-1] = '+';dfs(start+1, cur, total+cur);
            ops[start-1] = '-';dfs(start+1, -cur, total-cur);
            ops[start-1] = '*';dfs(start+1, pre*cur, total-pre+pre*cur);
            start++;
        }
    }
    private void addToRes() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<num.length; i++) {
            if(i>0 && ops[i-1] != ' '){
                sb.append(ops[i-1]);
            }
            sb.append(num[i]);
        }
        this.res.add(sb.toString());
    }
}

