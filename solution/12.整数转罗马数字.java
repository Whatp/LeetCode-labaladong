/*
 * @lc app=leetcode.cn id=12 lang=java
 * @lcpr version=30201
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        // 按从大到小列出所有可能的罗马数字组合
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            // 这里必须是while，因为可能是3000，这样的话，会有三个M
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
            // 节省时间，避免不必要的循环
            if (num == 0)
                break;
        }
        return sb.toString();
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 3749\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 58\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 1994\n
 * // @lcpr case=end
 * 
 */
