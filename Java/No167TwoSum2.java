/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 */
class No167TwoSum2  {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for(int i=0, j=numbers.length-1; i<j; ){
            int sum = numbers[i] + numbers[j];
            if(sum > target) j--;
            else if(sum < target) i++;
            else {
                res[0] = i+1;
                res[1] = j+1;
                break;
            }
        }
        return res;
    }
}

