/*
 * @lc app=leetcode.cn id=67 lang=java
 * @lcpr version=30202
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        /**
         * 从右往左开始加
         */
        int m = a.length() - 1;
        int n = b.length() - 1;
        StringBuilder res = new StringBuilder();
        // 进位
        int carry = 0;
        // 从右往左逐行相加
        while (m >= 0 || n >= 0) {
            // 进位，从右往左逐位相加
            int sum = carry;
            if (m >= 0) {
                sum += a.charAt(m) - '0';
                m--;
            }
            if (n >= 0) {
                sum += b.charAt(n) - '0';
                n--;
            }
            res.append(sum % 2);
            carry = sum / 2;
        }
        
        // 如果有剩余的位
        if (carry != 0) {
            res.append(carry);
        }

        return res.reverse().toString();        
    }
}
// @lc code=end



/*
// @lcpr case=start
// "11"\n"1"\n
// @lcpr case=end

// @lcpr case=start
// "1010"\n"1011"\n
// @lcpr case=end

 */

