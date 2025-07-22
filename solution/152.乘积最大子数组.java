/*
 * @lc app=leetcode.cn id=152 lang=java
 * @lcpr version=30201
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        // dp[i]数组代表以nums[i]为结尾的子数组的乘积
        int[] maxdp = new int[nums.length + 1];
        int[] mindp = new int[nums.length + 1];
        int max = nums[0];
        maxdp[0] = nums[0];
        mindp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxdp[i] = Math.max(nums[i], Math.max(maxdp[i - 1] * nums[i], mindp[i - 1] * nums[i]));
            mindp[i] = Math.min(nums[i], Math.min(maxdp[i - 1] * nums[i], mindp[i - 1] * nums[i]));
            max = Math.max(max, maxdp[i]);
        }
        return max;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,3,-2,4]\n
// @lcpr case=end

// @lcpr case=start
// [-2,0,-1]\n
// @lcpr case=end

 */

