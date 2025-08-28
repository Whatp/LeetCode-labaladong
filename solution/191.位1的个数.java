/*
 * @lc app=leetcode.cn id=191 lang=java
 * @lcpr version=30202
 *
 * [191] 位1的个数
 */

// @lc code=start
class Solution {
    public int hammingWeight2(int n) {
        String s = Integer.toBinaryString(n);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                res++;
            }
        }
        return res;
    }

    /**
     * 方法二
     * 观察这个运算：n & (n−1)，其运算结果恰为把 n 的二进制位中的最低位的 1 变为 0 之后的结果。

    如：6 & (6−1)=4,6=(110)  4=(100) 
​
    运算结果 4 即为把 6 的二进制位中的最低位的 1 变为 0 之后的结果。

这样我们可以利用这个位运算的性质加速我们的检查过程，在实际代码中，我们不断让当前的 n 与 n−1 做与运算，直到 n 变为 0 即可。
因为每次运算会使得 n 的最低位的 1 被翻转，因此运算次数就等于 n 的二进制位中 1 的个数。
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        } 
        return res;
    }

}
// @lc code=end



/*
// @lcpr case=start
// 11\n
// @lcpr case=end

// @lcpr case=start
// 128\n
// @lcpr case=end

// @lcpr case=start
// 2147483645\n
// @lcpr case=end

 */

