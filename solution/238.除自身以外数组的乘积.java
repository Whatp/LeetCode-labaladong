/*
 * @lc app=leetcode.cn id=238 lang=java
 * @lcpr version=30201
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        /**
         * 从从左往右遍历，计算左乘积，再从右往左遍历，直接计算出answer
         */
        int[] answer = new int[nums.length];
        answer[0] = 1;
        for (int i = 1; i < answer.length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }
        int R = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            R *= nums[i];
        }
        return answer;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4]\n
// @lcpr case=end

// @lcpr case=start
// [-1,1,0,-3,3]\n
// @lcpr case=end

 */

