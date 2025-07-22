/*
 * @lc app=leetcode.cn id=45 lang=java
 * @lcpr version=30201
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        // 最小的跳跃次数
        int minJump = 0;
        int farthest = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                minJump++;
                end = farthest;
            }
        }
        return minJump;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,3,1,1,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,3,0,1,4]\n
 * // @lcpr case=end
 * 
 */
