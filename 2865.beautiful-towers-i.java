/*
 * @lc app=leetcode id=2865 lang=java
 *
 * [2865] Beautiful Towers I
 */

// @lc code=start
class Solution {
    public long maximumSumOfHeights(int[] heights) {
        long totalVolume = 0 ;
        for(int height : heights)
            totalVolume += height ;
        long result = 0 ;
        for(int i=0; i< heights.length;i++){
            result = Math.max(result, totalVolume-exapndAroundIndex(heights, i)) ;
            System.out.println(i + " " + result) ;
        }
        return result ;
    }

    private long exapndAroundIndex(int[] heights, int index){
        int curr_max = heights[index] ;
        int i = index ;
        long bricksRemoved = 0 ;
        while(i >= 0){
            if(heights[i] > curr_max)
                bricksRemoved += heights[i] - curr_max ;
            else curr_max = heights[i] ;
            i-- ;
        }
        i = index ;
        curr_max = heights[index] ;
        while(i < heights.length){
            if(heights[i] > curr_max)
                bricksRemoved += heights[i] - curr_max ;
            else curr_max = heights[i] ;
            i++ ;
        }
        return bricksRemoved ;
    }
}
// @lc code=end

