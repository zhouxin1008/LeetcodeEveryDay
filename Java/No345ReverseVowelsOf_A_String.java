import java.util.HashSet;

/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */
class No345ReverseVowelsOf_A_String {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int left = 0, right = str.length-1;
        while(left < right) {
            if(isVowal(str[left]) && isVowal(str[right])){
                swap(str, left++, right--);
                continue;
            }
            if(!isVowal(str[left])){
                left++;
                continue;
            }
            if(!isVowal(str[right])){
                right--;
                continue;
            }
        }
        return new String(str);
    }
    private void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    private boolean isVowal(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || 
        c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
    }
}

