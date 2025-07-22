/*
 * @lc app=leetcode.cn id=416 lang=java
 * @lcpr version=30201
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)
            return false;
        int n = nums.length;
        sum /= 2;
        // dp[i][j] 数组表示前i个物品，前背包的容量为j时
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,5,11,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3,5]\n
 * // @lcpr case=end
 * 
 */
