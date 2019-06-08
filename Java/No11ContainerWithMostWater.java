class No11ContainerWithMostWater {
  public int maxArea(int[] height) {
    int i = 0;
    int j = height.length - 1;
    int max = 0;
    while (i < j) {
      int left = height[i];
      int right = height[j];
      if ( left <= right ) {
        max = Math.max(max, left * (j-i));
        i++;
      } else if ( left > right ) {
        max = Math.max(max, right * (j-i));
        j--;
      }
    }
    return max;
  }
}