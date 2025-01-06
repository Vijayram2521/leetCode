/*
 * @lc app=leetcode id=2944 lang=java
 *
 * [2944] Minimum Number of Coins for Fruits
 */

// @lc code=start
class Solution {
    public int minimumCoins(int[] A) {
        int n = A.length, dp[] = new int[n + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && (q.getFirst() + 1) * 2 < i + 1)
                q.removeFirst();
            while (!q.isEmpty() && dp[q.getLast()] + A[q.getLast()] >= dp[i] + A[i])
                q.removeLast();
            q.addLast(i);
            dp[i + 1] = dp[q.getFirst()] + A[q.getFirst()];
        }
        return dp[n];
    }
}
// @lc code=end

