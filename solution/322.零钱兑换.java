/*
 * @lc app=leetcode.cn id=322 lang=java
 * @lcpr version=30201
 *
 * [322] 零钱兑换
 */

// @lc code=start

import java.util.Arrays;

class Solution {

    /**
     * 考虑自底向上的解法
     * dp[i] 的定义是什么，凑金额 i 最少需要dp[i]枚硬币
     * 类比爬楼梯，爬11层楼，可以选择一次爬5楼、2楼、1楼，怎么选最少
     * i就是当前爬楼梯中当前要达到的层数，
     * 在这里就是金钱数
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i < coin) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
// @lc code=end



/*
// @lcpr case=start
// [1, 2, 5]\n11\n
// @lcpr case=end

// @lcpr case=start
// [2]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n0\n
// @lcpr case=end

 */

