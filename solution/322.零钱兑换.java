/*
 * @lc app=leetcode.cn id=322 lang=java
 * @lcpr version=30201
 *
 * [322] 零钱兑换
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    int moemo[];
    public int coinChange(int[] coins, int amount) {
        moemo = new int[amount + 1];
        Arrays.fill(moemo, -66);

        return dp(coins, amount);

    }

    int dp(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        if (moemo[amount] != -66) return moemo[amount];

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin);
            if (subProblem == -1) continue;
            res = Math.min(res, subProblem + 1);
        }
        moemo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return moemo[amount];
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

