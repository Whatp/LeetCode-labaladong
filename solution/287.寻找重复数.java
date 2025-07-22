/*
 * @lc app=leetcode.cn id=287 lang=java
 * @lcpr version=30201
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,3,4,2,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,1,3,4,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,3,3,3,3]\n
 * // @lcpr case=end
 * 
 */
