/*
 * @lc app=leetcode.cn id=33 lang=java
 * @lcpr version=30202
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    // 我们需要判断左右哪部分是有序的
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1; 
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            // 说明左半部分是有序的
            if (nums[left] <= nums[mid]) {
                // target在有序的左半部分目标内
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 右半部分有序 
            else {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [4,5,6,7,0,1,2]\n0\n
// @lcpr case=end

// @lcpr case=start
// [4,5,6,7,0,1,2]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n0\n
// @lcpr case=end

 */

