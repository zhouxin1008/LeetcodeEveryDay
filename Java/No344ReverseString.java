/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 */
class No344ReverseString {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while(left < right) {
            swap(s, left++, right--);
        }
    }
    private void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}

