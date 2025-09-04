/*
 * @lc app=leetcode.cn id=70 lang=java
 * @lcpr version=30201
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        /**
         * 如果想要爬到第n阶，要么从第n - 1上去，要么从n - 2上去，只有这两个
         * 也就是状态转移方程 dp[n] = dp[n - 1] + dp[n - 2]
         * dp[i] 是 爬到 第 i阶有dp[i]中方法
         */
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 4\n
 * // @lcpr case=end
 * 
 */
