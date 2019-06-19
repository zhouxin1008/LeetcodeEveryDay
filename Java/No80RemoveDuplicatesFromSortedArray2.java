/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */
class No80RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        Integer last = null;
        Boolean secondTime = false;
        int i=0;
        int j=0;
        while(j < nums.length) {
            if(last!=null && nums[j] == last){
                if(secondTime != true){
                    secondTime = true;
                    nums[i++] = nums[j];
                }
            }else{
                last = nums[j];
                secondTime = false;
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}

