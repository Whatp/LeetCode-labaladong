/*
 * @lc app=leetcode.cn id=26 lang=java
 * @lcpr version=30201
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        // 在原数组进行操作，返回一个数组长度
        int l = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[l] != nums[i]) {
                l++;
                nums[l] = nums[i];
            } 
        }
        return l + 1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [0,0,1,1,1,2,2,3,3,4]\n
// @lcpr case=end

 */

