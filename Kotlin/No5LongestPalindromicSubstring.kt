fun longestPalindrome(s: String): String {
  val len = s.length()
  return if (len == 1) s
  else {
    val mark = Array(len){BooleanArray(len)}
    var max = 0
    var left = 0
    val str = s.toCharArray()
    for(i in 0 until len) {
      for(j in i until len) {
        if (i <= 1) mark[j-i][j] = str[j-i] == str[j];
        else mark[j-i][j] = mark[j-i+1][j-1] && str[j-i] == str[j];
        if (mark[j-i][j] && max < i+1) {
          max = i + 1;
          left = j - i;
        }
      }
    }
    s.substring(left, left+max)
  }
}