/*
 * @lc app=leetcode.cn id=198 lang=java
 * @lcpr version=30201
 *
 * [198] 打家劫舍
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    /**
     * 如果我们用备忘录的方式，也就是自顶向下，备忘录记的是什么？
     * memo[i]也是nums[i]结尾的最大金额
     * @param nums
     * @return
     */
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }

    public int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }

        if (memo[start] != -1) {
            return nums[start];
        }
        int res = Math.max((nums[start] + dp(nums, start + 2)), dp(nums, start + 1));
        memo[start] = res;
        return res;        
    }
}

class Solution2 {
    /**
     * 我们就想一下dp[i]定义是什么，怎么推导
     * dp[i] 是以nums[i] 结尾的最大金额，返回的时候返回dp[nums.length]
     * 选当前的或者不选，选的话就是dp[i - 2] + nums[i]，不选就是dp[i - 1]不变
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // base case
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
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
