/*
 * @lc app=leetcode.cn id=172 lang=java
 * @lcpr version=30202
 *
 * [172] 阶乘后的零
 */

// @lc code=start
class Solution {
    public int trailingZeroes(int n) {
        /*
         * 阶乘后的零，是由2和5相乘得到的，而2的数量远大于5，所以只要计算5的个数就
         */
        int res = 0;
        while (n > 0) {
            n /= 5;
            res += n;
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 5\n
// @lcpr case=end

// @lcpr case=start
// 0\n
// @lcpr case=end

 */

