import java.util.Arrays;

class No16ThreeSumClosest {
  public int threeSumClosest(int[] nums, int target) {
    int len = nums.length;
    if (len <= 3) {
      int sum = 0;
      for(int i : nums) {
        sum += i;
      }
      return sum;
    }
    Arrays.sort(nums);
    Integer res = null;
    for(int i=0; i<nums.length-2; i++) {
      int temp = twoSumClosest(nums, i+1, nums[i], target);
      if (res == null || Math.abs(res - target) > Math.abs(temp - target)) {
        res = temp;
      }
    }
    return res;
  }

  public int twoSumClosest(int[] nums, int left, int first ,int target) {
    Integer res = null;
    for(int i=left, j=nums.length-1; i<j;) {
      int sum = first + nums[i] + nums[j];
      if (res == null || Math.abs(res - target) > Math.abs(sum - target)) {
        res = sum;
      }
      if (sum > target) j--;
      else if (sum < target) i++;
      else break;
    }
    return res;
  }
}