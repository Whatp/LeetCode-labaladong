/*
 * @lc app=leetcode.cn id=50 lang=java
 * @lcpr version=30202
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) {
            return myPow(1 / x, -(n + 1)) / x;
        }

        if (n < 0) {
            return myPow(1 / x, -n);
        }
        if (n % 2 == 1) {
            return (x * myPow(x, n - 1));
        } else {
            double sub = myPow(x, n / 2);
            return (sub * sub);
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// 2.00000\n10\n
// @lcpr case=end

// @lcpr case=start
// 2.10000\n3\n
// @lcpr case=end

// @lcpr case=start
// 2.00000\n-2\n
// @lcpr case=end

 */

