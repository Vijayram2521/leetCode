/*
 * @lc app=leetcode id=817 lang=java
 *
 * [817] Linked List Components
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> n = new HashSet<>() ;
        for(int i : nums)
            n.add(i) ;
        return numComponentsHelper(head, n) ;
    }

    public int numComponentsHelper(ListNode head, Set<Integer> nums){
        if(head == null)
            return 0 ;
        int next = numComponentsHelper(head.next, nums) ;
        if(nums.contains(head.val) && (head.next == null || !nums.contains(head.next.val)))
            next++ ;
        return next ;
    }
}
// @lc code=end

