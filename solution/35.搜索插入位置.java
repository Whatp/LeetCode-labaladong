/*
 * @lc app=leetcode.cn id=35 lang=java
 * @lcpr version=30202
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (target <  nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 如果没有找到，就返回left就是要插入的位置
        return left;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,3,5,6]\n5\n
// @lcpr case=end

// @lcpr case=start
// [1,3,5,6]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,3,5,6]\n7\n
// @lcpr case=end

 */

