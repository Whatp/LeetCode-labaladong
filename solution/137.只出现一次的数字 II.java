/*
 * @lc app=leetcode.cn id=137 lang=java
 * @lcpr version=30202
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    /**
     * 就像[6, 6, 6, 3]来说
     * 二进制是
     * 1 1 0
     * 1 1 0
     * 1 1 0
     * 0 1 1
     * 1出现的次数
     * 3 4 1
     * 对3取余
     * 0 1 1
     * 取余后的结果不是0的，就赋值为1
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum  = 0;
            for (int num : nums) {
                // 右移i位就是把第i位移到最低位，然后与上1，看结果
                sum  += num >> i & 1;
            }
            if (sum % 3 != 0) {
                // 把第i为设为1
                res |= 1 << i;
            }
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,2,3,2]\n
// @lcpr case=end

// @lcpr case=start
// [0,1,0,1,0,1,99]\n
// @lcpr case=end

 */

