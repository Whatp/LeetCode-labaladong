/*
 * @lc app=leetcode.cn id=162 lang=java
 * @lcpr version=30202
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    /**
     * 找到一个元素比两边的元素都大，返回下标
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {    
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            // 峰值在左侧
            if (nums[mid] > nums[mid + 1]) {
                j = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                // 峰值在右侧
                i = mid + 1;
            }
        }
        return i;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,1,3,5,6,4]\n
// @lcpr case=end

 */

