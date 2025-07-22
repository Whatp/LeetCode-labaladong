/*
 * @lc app=leetcode.cn id=198 lang=java
 * @lcpr version=30201
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution1 {
    private int[] memo;

    public int rob(int[] nums) {

        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return dp(nums, 0);
    }

    public int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }

        if (memo[start] != -1)
            return memo[start];

        int res = Math.max(dp(nums, start + 1), nums[start] + dp(nums, start + 2));
        memo[start] = res;
        return res;

    }
}

class Solution2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,7,9,3,1]\n
 * // @lcpr case=end
 * 
 */
