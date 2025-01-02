/*
 * @lc app=leetcode id=2598 lang=java
 *
 * [2598] Smallest Missing Non-negative Integer After Operations
 */

// @lc code=start
class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Arrays.sort(nums) ;
        int target = 0 ;
        int[] moduloFreqMap = new int[value] ;
        for(int i=0; i<nums.length;i++){
            int mod = ((nums[i] % value) + value) % value ;
            moduloFreqMap[mod]++ ;
        }
        int min_freq = moduloFreqMap[0], min_freq_index = 0 ;
        for(int i=1; i<value;i++){
            if(moduloFreqMap[i] < min_freq){
                min_freq = moduloFreqMap[i] ;
                min_freq_index = i ;
            }
        }
        return value*min_freq + min_freq_index ;
    }
}
// @lc code=end

