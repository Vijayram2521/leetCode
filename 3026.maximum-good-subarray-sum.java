/*
 * @lc app=leetcode id=3026 lang=java
 *
 * [3026] Maximum Good Subarray Sum
 */

// @lc code=start
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long[] prefixSum = new long[nums.length+1] ;
        prefixSum[0] = 0 ;
        for(int i=0; i<nums.length;i++)
            prefixSum[i+1] = prefixSum[i] + nums[i] ;

        long res = Long.MIN_VALUE ;
        Map<Integer, Long> mp = new HashMap<>() ;
        for(int i=0; i<nums.length;i++){
            int target = nums[i]-k ;
            if(mp.containsKey(target)){
                res = Math.max(res, prefixSum[i+1] - mp.get(target)) ;
            }
            target = nums[i]+k ;
            if(mp.containsKey(target)){
                res = Math.max(res, prefixSum[i+1] - mp.get(target)) ;
            }

            if(!mp.containsKey(nums[i]) || prefixSum[i] < mp.get(nums[i]))
                mp.put(nums[i], prefixSum[i]) ;
            //System.out.println(i+ " "+ res) ;
        }
        return res == Long.MIN_VALUE ? 0 : res ;
    }
}
// @lc code=end

