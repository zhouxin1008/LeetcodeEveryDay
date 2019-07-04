/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */
class No151ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=strs.length; i>0; i--) {
            String str = strs[i-1];
            if(!str.isEmpty()){
                sb.append(str);
                sb.append(" ");
            }
        }
        String res = sb.toString();
        if(res.isEmpty()) return res;
        return res.substring(0, res.length()-1);
    }
}

