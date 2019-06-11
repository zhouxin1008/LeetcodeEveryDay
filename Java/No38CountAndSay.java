/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */
class No38CountAndSay {
    public String countAndSay(int n) {
        String res = "1";
        while(n > 1) {
            res = count(res.toCharArray());
            n--;
        }
        return res;
    }
    private String count(char[] s) {
        Character last = null;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(char c : s) {
            if(last==null || last == c) {
                last = c;
                count++;
            } else {
                sb.append(count);
                sb.append(last);
                count = 1;
                last = c;
            }
        }
        sb.append(count);
        sb.append(last);
        return sb.toString();
    }
}

