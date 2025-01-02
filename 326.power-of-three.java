/*
 * @lc app=leetcode id=326 lang=java
 *
 * [326] Power of Three
 */

// @lc code=start
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n < 3)
            return n == 1 ;
        return n%3 == 0 ? isPowerOfThree(n/3) : false ;
    }
}
// @lc code=end

