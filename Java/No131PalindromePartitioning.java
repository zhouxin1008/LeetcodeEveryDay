import java.util.ArrayList;

/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */
class No131PalindromePartitioning {
    private boolean[][] dp;
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        if(s==null || s.isEmpty()) return res;
        int len = s.length();
        dp = new boolean[len][len];
        char[] str = s.toCharArray();
        for(int i=0; i<len; i++){
            for(int j=0; j+i<len; j++){
                if(i==0){
                    dp[j][j+i] = true;
                }else if(i==1){
                    dp[j][j+i] = str[j]==str[j+i];
                }else{
                    dp[j][j+i] = str[j]==str[j+i] && dp[j+1][j+i-1];
                }
            }
        }
        getRes(0, len, new ArrayList<String>(), s);
        return res;
    }
    private void getRes(int index, int len, List<String> list, String s) {
        if(index == len) {
            res.add(list);
            return;
        }
        for(int i=0; i+index<len; i++){
            if(dp[index][index+i] == true){
                List<String> newList = new ArrayList<>(list);
                newList.add(s.substring(index,index+i+1));
                getRes(index+i+1, len, newList, s);
            }
        }
    }
    
}

