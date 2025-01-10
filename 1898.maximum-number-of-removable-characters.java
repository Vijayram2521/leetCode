/*
 * @lc app=leetcode id=1898 lang=java
 *
 * [1898] Maximum Number of Removable Characters
 */

// @lc code=start


class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
      int lo = 0 , hi = removable.length-1 ;
      int max_removals = 0 ;
      while(lo <= hi){
        int mid = (lo+hi)/2 ;
        if(checkMatch(s, p, removable, mid)){
            max_removals = mid+1 ;
            lo = mid+1 ;
        }
        else{
            hi = mid-1 ;
        }
      }   
      return max_removals ;
    }

    private boolean checkMatch(String s, String p, int[] removable, int k){
        char[] temp = s.toCharArray() ;
        for(int i=0; i<=k;i++){
            temp[removable[i]] = '/' ;
        }

        int i=0, j=0; 
        while(i < p.length() && j < s.length()){
            if(p.charAt(i) == temp[j]){
                i++ ;
                j++ ;
            }
            else j++ ;
        }
        return i == p.length() ;
    }
}
// @lc code=end

