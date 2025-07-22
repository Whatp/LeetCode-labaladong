/*
 * @lc app=leetcode.cn id=128 lang=java
 * @lcpr version=30201
 *
 * [128] 最长连续序列
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int curLen = 1, maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;

            if (nums[i] - nums[i - 1] == 1) {
                curLen++;
                maxLen = Math.max(maxLen, curLen);
            } else {
                curLen = 1;
            }
        }
        return maxLen;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [100,4,200,1,3,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,3,7,2,5,8,4,6,0,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,0,1,2]\n
 * // @lcpr case=end
 * 
 */
