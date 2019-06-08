class No8StringToInteger {
  public int myAtoi(String str) {
    String trimedStr = str.trim();
    if (trimedStr.length() == 0) return 0;
    char first = trimedStr.charAt(0);
    boolean positive = true;
    if ( first == '-' ) {
      positive = false;
      trimedStr = trimedStr.substring(1);
    } else if (first == '+') {
      trimedStr = trimedStr.substring(1);
    } else if (first > '9' || first < '0') {
      return 0;
    }
    long res = 0;
    for (char c : trimedStr.toCharArray()) {
      if ( c > '9' || c < '0' || res > Integer.MAX_VALUE) break;
      res = res*10 + (c - '0');
    }
    res = positive ? res : -res;
    if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
    if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
    return (int)res;
  }
}