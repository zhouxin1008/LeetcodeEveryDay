import java.util.ArrayList;
import java.util.Arrays;

class No18FourSum {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums.length < 4) return res;
    Arrays.sort(nums);
    for (int i=0; i<nums.length-3;i++) {
      if (i != 0 && nums[i] == nums[i-1]) continue;
      res.addAll(threeSum(nums, i+1, nums[i], target));
    }
    return res;
  }
  private List<List<Integer>> threeSum(int[] nums, int left, int first, int target) {
    List<List<Integer>> res = new ArrayList<>();
    for (int i=left; i<nums.length-2;i++) {
      if (i != left && nums[i] == nums[i-1]) continue;
      res.addAll(twoSum(nums, i+1, first, nums[i], target));
    }
    return res;
  }
  private List<List<Integer>> twoSum(int[] nums, int left, int first, int second, int target) {
    List<List<Integer>> res = new ArrayList<>();
    boolean lastHit = false;
    for(int i=left,j=nums.length-1; i<j;) {
      int sum = first + second + nums[i] + nums[j];
      if (sum > target) {
        lastHit = false;
        j--;
      } else if (sum < target) {
        lastHit = false;
        i++;
      } else {
        if (lastHit) i++;
        else {
          res.add(Arrays.asList(first, second, nums[i], nums[j]));
          lastHit = true;
        }
      }
    }
    return res;
  }
}