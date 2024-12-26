/*
 * @lc app=leetcode id=2729 lang=java
 *
 * [2729] Check if The Number is Fascinating
 */

// @lc code=start
class Solution {
    public boolean isFascinating(int n) {
        StringBuilder s = new StringBuilder(String.valueOf(n)) ;
        s.append(String.valueOf(2*n)) ;
        s.append(String.valueOf(3*n)) ;
        int[] mp = new int[10] ;
        for(int i=0; i<s.length();i++){
            mp[s.charAt(i)-'0']++ ;
        }
        if(mp[0] > 0)
            return false;
        for(int i=1; i<10;i++){
            if(mp[i] != 1)
                return false ;
        }
        return true ;
    }
}
// @lc code=end

