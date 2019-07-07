/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */
class No169MajorityElement {
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for(int num : nums){
            if(count==0){
                res = num;
                count=1;
            }else if(res == num){
                count++;
            }else {
                count--;
            }
        }
        return res;
    }
}

