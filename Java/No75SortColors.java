/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */
class No75SortColors {
    public void sortColors(int[] nums) {
        int num0 = 0;
        int num1 = 0;
        int num2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) num0++;
            if(nums[i] == 1) num1++;
            if(nums[i] == 2) num2++;
        }
        int index = 0;
        while(num0 > 0){
            nums[index++] = 0;
            num0--;
        }
        while(num1 > 0){
            nums[index++] = 1;
            num1--;
        }
        while(num2 > 0){
            nums[index++] = 2;
            num2--;
        }
    }
}

