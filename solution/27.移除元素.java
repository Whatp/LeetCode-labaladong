/*
 * @lc app=leetcode.cn id=27 lang=java
 * @lcpr version=30201
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[l] = nums[i];
                l++;
            }
        }
        return l;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,2,2,3]\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,1,2,2,3,0,4,2]\n2\n
 * // @lcpr case=end
 * 
 */
