class No5LongestPalindromicSubstring {
  public String longestPalindrome1(String s) {
    int len = s.length();
    if (len == 1) return s;
    boolean[][] mark = new boolean[len][len];
    int max = 0;
    int left = 0;
    char[] str = s.toCharArray();
    for(int i = 0; i < len; i++) {
      for(int j = i; j < len; j++) {
        if ( i <= 1) mark[j-i][j] = str[j-i] == str[j];
        else mark[j-i][j] = mark[j-i+1][j-1] && str[j-i] == str[j];

        if (mark[j-i][j] && max < i+1) {
          max = i + 1;
          left = j - i;
        }
      }
    }
    return s.substring(left, left+max);
  }

  public String longestPalindrome2(String s) {
    int len = s.length();
    if (len == 1) return s;
    boolean[] markEven = new boolean[len];
    boolean[] markOdd = new boolean[len];
    int max = 0;
    int left = 0;
    char[] str = s.toCharArray();
    for(int i = 0; i < len; i++) {
      for(int j = i; j < len; j++) {
        if ( i % 2 == 0 ) {
          if ( i == 0 ) markEven[j] = true;
          else markEven[j-i] = markEven[j-i+1] && str[j-i] == str[j];
  
          if (markEven[j-i] && max < i+1) {
            max = i + 1;
            left = j - i;
          }
        } else {
          if ( i == 1 ) markOdd[j-1] = str[j-1] == str[j];
          else markOdd[j-i] = markOdd[j-i+1] && str[j-i] == str[j];
  
          if (markOdd[j-i] && max < i+1) {
            max = i + 1;
            left = j - i;
          }
        }
      }
    }
    return s.substring(left, left+max);
  }
}