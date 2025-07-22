/*
 * @lc app=leetcode.cn id=11 lang=java
 * @lcpr version=30201
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            res = Math.max(res, area);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,8,6,2,5,4,8,3,7]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,1]\n
 * // @lcpr case=end
 * 
 */
