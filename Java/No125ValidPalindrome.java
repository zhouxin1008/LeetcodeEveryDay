/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */
class No125ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s==null || s.isEmpty()) return true;
        char[] temp = s.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder sbr = new StringBuilder();
        for(int i=0; i<temp.length; i++){
            if((temp[i]>='a' && temp[i]<='z') || (temp[i]>='0' && temp[i]<='9')){
                sb.append(temp[i]);
                sbr.insert(0, temp[i]);
            }
        }
        return sb.toString().equals(sbr.toString());
    }
}

