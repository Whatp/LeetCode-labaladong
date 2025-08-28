/*
 * @lc app=leetcode.cn id=136 lang=java
 * @lcpr version=30202
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        /**
         * 利用了异或的性质，任何数异或零是任何数
         * 任何数异或本身是0，那么从头到尾异或一遍
         */
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [4,1,2,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

