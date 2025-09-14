/*
 * @lc app=leetcode.cn id=343 lang=java
 * @lcpr version=30203
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        /**
         * 最大就是拆分成n个数了
         * 遍历，用动态规划，遍历所有可能的状态
         */
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                int temp = Math.max(j * (i - j), j * dp[i - j]);
                max = Math.max(max, temp);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
// @lc code=end



/*
// @lcpr case=start
// 2\n
// @lcpr case=end

// @lcpr case=start
// 10\n
// @lcpr case=end

 */

