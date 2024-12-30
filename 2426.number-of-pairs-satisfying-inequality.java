/*
 * @lc app=leetcode id=2426 lang=java
 *
 * [2426] Number of Pairs Satisfying Inequality
 */

// @lc code=start
class Solution {
    //construct a tree with frequency indices
    class TreeNode{
        int val ;
        int freq ;
        TreeNode left ;
        TreeNode right ;
        int left_count ;
        int right_count ;
        TreeNode(int x){
            this.val = x ;
            this.left = null ;
            this.right = null ;
            this.freq = 1 ;
            this.left_count = 0 ;
            this.right_count = 0 ;
        }
    }
    private void insert(TreeNode root, int val){
        if(root.val == val){
            root.left_count += 1 ;
        }
        else if(root.val > val){
            root.left_count = root.left_count + 1 ;
            if(root.left == null){
                root.left = new TreeNode(val) ;
            }
            else insert(root.left, val) ;
        }
        else {
            root.right_count = root.right_count + 1 ;
            if(root.right == null){
                root.right = new TreeNode(val) ;
            }
            else insert(root.right, val) ;
        }
    }
    //get number of nodes less than or equal to give val
    private int query(TreeNode root, int val){
        if(root.val > val && root.left == null)
            return 0 ;
        else if(root.val > val)
            return query(root.left, val) ;
        int res = 1 + root.left_count ;
        if(root.right != null)
            res += query(root.right, val) ;
        return res ;
    }
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        for(int i=0; i< nums1.length;i++)
            nums1[i] -= nums2[i] ;
        long count = 0 ;
        TreeNode root = new TreeNode(nums1[0]) ;
        for(int i=1; i<nums1.length;i++){
            count += query(root, nums1[i]+diff) ;
            insert(root, nums1[i]) ;
        }
       // insert(root, nums1[1]) ;
        return count ;
    }
}
// @lc code=end

