class No9PalindromeNumber {
  public boolean isPalindrome(int x) {
    if ( x < 0 ) return false;
    char[] array = String.valueOf(x).toCharArray();
    for (int i=0, j=array.length-1; i <= j; i++, j--) {
      if (array[i] != array[j]) return false;
    }   
    return true;
  }
}