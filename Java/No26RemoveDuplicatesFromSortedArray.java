/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */
class No26RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int pointer = 0;
        while(pointer < nums.length) {
            if(pointer == 0 || nums[pointer] != nums[pointer-1]) {
                nums[index++] = nums[pointer];
            }
            pointer++;
        }
        return index;
    }
}

