/*
 * @lc app=leetcode.cn id=201 lang=java
 * @lcpr version=30202
 *
 * [201] 数字范围按位与
 */

// @lc code=start
class Solution {
    public int rangeBitwiseAnd1(int left, int right) {
        while (right > left) {
            right &= right - 1;
        }
        return right;
    }
     public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        // 右移直到 left 和 right 相等
        while (left < right) {
            left >>= 1;  // 左边界右移一位
            right >>= 1; // 右边界右移一位
            shift++;     // 记录右移次数
        }
        // 将公共前缀左移 shift 位，得到最终结果
        return left << shift;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 5\n7\n
// @lcpr case=end

// @lcpr case=start
// 0\n0\n
// @lcpr case=end

// @lcpr case=start
// 1\n2147483647\n
// @lcpr case=end

 */

