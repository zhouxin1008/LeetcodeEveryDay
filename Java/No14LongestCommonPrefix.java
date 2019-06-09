class No14LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    int len = Integer.MAX_VALUE;
    for (String str : strs) {
      len = Math.min(len, str.length());
    }
    for (int i=0; i<len; i++) {
      Character c = null;
      for(String str : strs) {
        if (c == null) c = str.charAt(i);
        else if (c != str.charAt(i)) {
          return i==0 ? "" : str.substring(0, i);
        }
      }
      c = null;
    }
    return strs[0].substring(0, len);
  }
}