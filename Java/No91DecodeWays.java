/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */
class No91DecodeWays {
    public int numDecodings(String s) {
        if(s.startsWith("0")) return 0;
        char[] chars = s.toCharArray();
        int[] res = new int[chars.length];
        res[0] = 1;
        for(int i=1; i<chars.length; i++){
            char c = chars[i];
            char p = chars[i-1];
            if(c=='0') {
                if(p!='1' && p!='2') return 0;
                res[i] = i>=2?res[i-2]:1;
                continue;
            }
            if((c<='6'&&p=='2')||(p=='1')){
                res[i] = res[i-1] + (i>=2?res[i-2]:1);
                continue;
            }
            else res[i] = res[i-1];
        }
        return res[chars.length-1];
    }
}

