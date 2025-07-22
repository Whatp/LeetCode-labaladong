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
        // dp[i] 表示 nums[i] 这个数字结尾的最长递归子序列长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i : dp) {
            res = Math.max(res, i);
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

