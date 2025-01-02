/*
 * @lc app=leetcode id=1289 lang=java
 *
 * [1289] Minimum Falling Path Sum II
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] grid) {
        Map<Integer,Map<Integer,Integer>> cache = new HashMap<>() ;
        return minFallingPathSumHelper(grid, 0, -1, cache) ;
    }

    private int minFallingPathSumHelper(int[][] grid, int curr_row, int prev_col, Map<Integer,Map<Integer,Integer>> cache){
        if(curr_row == grid.length)
            return 0 ;
        if(cache.containsKey(curr_row) && cache.get(curr_row).containsKey(prev_col))
            return cache.get(curr_row).get(prev_col) ;
        int minSum = Integer.MAX_VALUE ;
        for(int i=0; i<grid[0].length;i++){
            if(i != prev_col){
                int curr_sum = grid[curr_row][i] + minFallingPathSumHelper(grid, curr_row+1, i, cache) ;
                minSum = Math.min(minSum, curr_sum) ;
            }
        }
        if(!cache.containsKey(curr_row)){
            cache.put(curr_row, new HashMap<>()) ;
        }
        cache.get(curr_row).put(prev_col, minSum) ;
        return minSum ;
    }
}
// @lc code=end

