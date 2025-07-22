/*
 * @lc app=leetcode.cn id=189 lang=java
 * @lcpr version=30201
 *
 * [189] 轮转数组
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
        /**
         * 移动的次数对长度取余就是最后一个元素所在的新位置
         */
        k %= nums.length;
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i]; 
        }
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,4,5,6,7]\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-1,-100,3,99]\n2\n
 * // @lcpr case=end
 * 
 */
