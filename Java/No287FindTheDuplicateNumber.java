import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */
class No287FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1;
        while(left < right) {
            if(right - left == 1) {
                if(count(nums, left)>1) return left;
                return right;
            }
            if((right - left) / 2 == 0) {
                if(count(nums, right) > 1){
                    return right;
                }else{
                    right--;
                    continue;
                }
            }
            int mid = left + (right-left) / 2;
            List<Integer> list = count(nums, left, mid, right);
            int countLeft = list.get(0);
            int countRight = list.get(1);
            if(countLeft > countRight){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    private int count(int[] nums, int i) {
        int count = 0;
        for(int num : nums){
            if(num == i) count++;
        }
        return count;
    }
    private List<Integer> count(int[] nums, int left, int mid, int right) {
        int countLeft = 0;
        int countRight = 0;
        for(int num : nums){
            if(num >= left && num <= mid) countLeft++;
            if(num >= mid+1 && num <= right) countRight++;
        }
        List<Integer> res = new ArrayList<>();
        res.add(countLeft);
        res.add(countRight);
        return res;
    }
}

