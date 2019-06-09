import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class No15ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> dealed = new HashSet<>();
    int len = nums.length;
    if (len < 3) return res;
    Arrays.sort(nums);
    for(int i=0; i<len-2; i++) {
      if (dealed.contains(nums[i])) continue;
      res.addAll(twoSum(nums, i+1, nums[i]));
      dealed.add(nums[i]);
    }
    return res;
  }

  public List<List<Integer>> twoSum(int[] nums, int left, int first) {
    Map<Integer, Boolean> map = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();
    int target = 0 - first;
    for (int i=left; i<nums.length; i++) {
      int num = nums[i];
      if (map.get(target - num) != null && map.get(target - num) == false) {
        map.put(target-num, true);
        map.put(num, true);
        res.add(Arrays.asList(first, target-num, num));
      } else if (map.get(target - num) == null) {
        map.put(num, false);
      }
    }
    return res;
  }
}