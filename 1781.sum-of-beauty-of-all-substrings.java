/*
 * @lc app=leetcode id=1781 lang=java
 *
 * [1781] Sum of Beauty of All Substrings
 */

// @lc code=start
class Solution {
    public int beautySum(String s) {
        int totalBeauty = 0 ;
        for(int i=0; i < s.length();i++){
            int[] freqMap = new int[26] ;
            for(int j=i;j < s.length();j++){
                freqMap[s.charAt(j)-'a']++ ;
                totalBeauty += getBeauty(freqMap) ;
            }
        }
        return totalBeauty ;
    }

    private int getBeauty(int[] freqMap){
        int maxValue = 0, minValue = Integer.MAX_VALUE ;
        for(int i=0; i<26;i++){
            maxValue = Math.max(maxValue, freqMap[i]) ;
            minValue = freqMap[i] != 0 ? Math.min(minValue, freqMap[i]) : minValue;
        }
        return maxValue-minValue ;
    }
}
// @lc code=end

