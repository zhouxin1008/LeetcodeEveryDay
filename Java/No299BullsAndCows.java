/*
 * @lc app=leetcode id=299 lang=java
 *
 * [299] Bulls and Cows
 */
class No299BullsAndCows {
    public String getHint(String secret, String guess) {
        int[] countS = new int[10];
        int[] countG = new int[10];
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        int countB = 0;
        for(int i=0; i<s.length; i++) {
            countS[s[i]-'0']++;
            countG[g[i]-'0']++;
            if(s[i] == g[i]) countB++;
        }
        int countC = 0;
        for(int i=0; i<10; i++) {
            countC += Math.min(countG[i], countS[i]);
        }
        return countB+"A"+(countC-countB)+"B";
    }
}

