/*
 * @lc app=leetcode id=835 lang=java
 *
 * [835] Image Overlap
 */

// @lc code=start
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length ;
        int overlap = 0 ;
        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){
                for(int k=0; k <n;k++){
                    for(int l=0; l<n;l++){
                        overlap = Math.max(overlap, checkOverlap(img1,img2,i,j,k,l)) ;
                    }
                }
            }
        }
        return overlap ;
    }

    private int checkOverlap(int[][] img1, int[][] img2, int x1, int y1, int x2, int y2){
        int overlap = 0 , n = img1.length;
        while(x1 < n && x2 < n){
            int y_one = y1 , y_two = y2 ;
            while(y_one < n && y_two < n){
                if(img1[x1][y_one] == 1 && img2[x2][y_two] == 1)
                    overlap++ ;
                y_one++ ;
                y_two++ ;
            }
            x1++ ;
            x2++ ;
        }
        return overlap ;
    }
}
// @lc code=end

