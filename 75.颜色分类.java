/*
 * @lc app=leetcode.cn id=75 lang=java
 * @lcpr version=30201
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        // 维护三个指针，p0指向0的右边界，p2指向2的左边界，p1指向当前遍历的元素
        int p0 = 0, p1 = 0, p2 = nums.length - 1;
        while (p1 <= p2) {
            if (nums[p1] == 0) {
                swap(nums, p0, p1);
                p0++;
                p1++;
            } else if (nums[p1] == 2) {
                swap(nums, p1, p2);
                p2--;
            } else {
                p1++;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,0,2,1,1,0]\n
// @lcpr case=end

// @lcpr case=start
// [2,0,1]\n
// @lcpr case=end

 */

