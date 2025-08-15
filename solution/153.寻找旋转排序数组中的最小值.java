/*
 * @lc app=leetcode.cn id=153 lang=java
 * @lcpr version=30202
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {

            int mid = left + (right - left) / 2;
            // 最小值在右侧
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // 最小值在左侧，也可能mid就是最小值
                right = mid;
            }
        }
        return nums[left];
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,4,5,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [4,5,6,7,0,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [11,13,15,17]\n
// @lcpr case=end

 */

