/*
 * @lc app=leetcode.cn id=80 lang=java
 * @lcpr version=30201
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int l = 1;
        int count = 1;
        for(int r = 1; r < nums.length; r++) {
            if (nums[r] == nums[r - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[l] = nums[r];
                l++;
            }
        }

        return l;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,1,1,2,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [0,0,1,1,1,1,2,3,3]\n
// @lcpr case=end

 */

