class No7ReverseInteger {
  public int reverse(int x) {
    boolean neg = x < 0;
    String s = neg ? String.valueOf(x).substring(1) : String.valueOf(x);
    String reversed = new StringBuilder(s).reverse().toString();
    long res = neg ? -Long.parseLong(reversed) : Long.parseLong(reversed);
    if ((neg && res < Integer.MIN_VALUE) || (!neg && res > Integer.MAX_VALUE)) {
      return 0;
    } else {
      return (int)res;
    }
  }
}