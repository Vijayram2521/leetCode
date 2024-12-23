/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int curr_element = nums[0] ;
        int curr_element_frequency = 1 ;
        for(int i=1; i<  nums.length;i++){
            if(nums[i] == curr_element)
                curr_element_frequency++ ;
            else if(curr_element_frequency > 0)
                curr_element_frequency--;
            else {
                curr_element = nums[i] ;
                curr_element_frequency++ ;
            }
        }
        return curr_element ;
    }
}
// @lc code=end

