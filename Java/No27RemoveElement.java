/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */
class No27RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        int pointer = 0;
        while(pointer < nums.length) {
            if(nums[pointer]!=val) {
                nums[index++] = nums[pointer];
            }
            pointer++;
        }
        return index;
    }
}

