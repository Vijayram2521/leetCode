/*
 * @lc app=leetcode id=3186 lang=java
 *
 * [3186] Maximum Total Damage With Spell Casting
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maximumTotalDamage(int[] power) {
        long[] dp = new long[power.length] ;
        Arrays.sort(power) ;
        return maxDamageHelper(power, 0, dp) ;
    }

    private long maxDamageHelper(int[] power, int index, long[] dp){
        if(index == power.length )
            return 0 ;
        if(dp[index] != 0)
            return dp[index] ;
        long curr_sum = 0 ;
        int curr_index  = index ;
        while(curr_index < power.length && power[curr_index] == power[index]){
            curr_sum += power[index] ;
            curr_index++ ;
        }
        long alt_sum = maxDamageHelper(power, curr_index, dp) ;
        while(curr_index < power.length && power[curr_index] <= power[index]+2){
            curr_index++ ;
        }
        curr_sum += maxDamageHelper(power, curr_index, dp) ;
        dp[index] = Math.max(curr_sum, alt_sum) ;
        return dp[index] ;
    }

    

}
// @lc code=end

