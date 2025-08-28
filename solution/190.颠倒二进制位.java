/*
 * @lc app=leetcode.cn id=190 lang=java
 * @lcpr version=30202
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // 先左移，给下一位留出位置
            res <<= 1;
            res |= (n & 1);
            n >>= 1;
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 43261596\n
// @lcpr case=end

// @lcpr case=start
// 2147483644\n
// @lcpr case=end

 */

