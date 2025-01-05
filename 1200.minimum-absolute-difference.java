/*
 * @lc app=leetcode id=1200 lang=java
 *
 * [1200] Minimum Absolute Difference
 */

// @lc code=start
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr) ;
        int curr_min_difference = Integer.MAX_VALUE ;
        for(int i=0; i< arr.length-1;i++){
            if(arr[i+1] - arr[i] < curr_min_difference )
                curr_min_difference = arr[i+1] - arr[i] ;
        }
        List<List<Integer>> result = new ArrayList<>() ;
        for(int i=0; i < arr.length-1;i++){
            if(arr[i+1] - arr[i] == curr_min_difference){
                List<Integer> temp = new ArrayList<>() ;
                temp.add(arr[i]) ;
                temp.add(arr[i+1]) ;
                result.add(temp ) ;
            }
        }
        return result ;
    }
}
// @lc code=end

