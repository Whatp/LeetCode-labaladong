/*
 * @lc app=leetcode.cn id=34 lang=java
 * @lcpr version=30202
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    /**
    相当于是寻找最左元素和寻找最右元素的结合
    */
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[]{-1, -1};
        // 最右元素，找到之后继续收缩左边界，也就是left = mid + 1
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return res;
        }
        res[1] = right;

        // 右边界是没有动的，所以只改左边界
        left = 0;
        // 最左元素，找到之后继续收缩左边界，也就是left = mid + 1
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return res;
        }
        res[0] = left;    

        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [5,7,7,8,8,10]\n8\n
// @lcpr case=end

// @lcpr case=start
// [5,7,7,8,8,10]\n6\n
// @lcpr case=end

// @lcpr case=start
// []\n0\n
// @lcpr case=end

 */

