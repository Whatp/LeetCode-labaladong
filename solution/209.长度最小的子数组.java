/*
 * @lc app=leetcode.cn id=209 lang=java
 * @lcpr version=30201
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int min_length = Integer.MAX_VALUE;

        // 思路就是滑动窗口，从left到right加过去，如果和大于等于target了，就开始
        // 收缩窗口
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // 尝试缩小窗口
            while (sum >= target) {
                min_length = Math.min(min_length, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return min_length == Integer.MAX_VALUE ? 0 : min_length;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 7\n[2,3,1,2,4,3]\n
// @lcpr case=end

// @lcpr case=start
// 4\n[1,4,4]\n
// @lcpr case=end

// @lcpr case=start
// 11\n[1,1,1,1,1,1,1,1]\n
// @lcpr case=end

 */

