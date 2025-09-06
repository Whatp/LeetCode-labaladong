/*
 * @lc app=leetcode.cn id=300 lang=java
 * @lcpr version=30201
 *
 * [300] 最长递增子序列
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        /**
         * dp[i] 代表以 i 结尾的最长递增子序列的长度，选择当前的或者不选
         */
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;

        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [10,9,2,5,3,7,101,18]\n
// @lcpr case=end

// @lcpr case=start
// [0,1,0,3,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [7,7,7,7,7,7,7]\n
// @lcpr case=end

 */

