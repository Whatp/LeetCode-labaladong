/*
 * @lc app=leetcode.cn id=957 lang=java
 * @lcpr version=30201
 *
 * [957] N 天后的牢房
 */

// @lc code=start
class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        // 周期为14，将数字映射到 1 - 14 之内，等价于 n = (n % 14 == 0) ? 14 : (n % 14);
        n = (n - 1) % 14 + 1;
        while (n-- > 0) {
            cells = getNextDay(cells);
        }

        return cells;
    }

    private int[] getNextDay(int[] cells) {
        int[] next = new int[8];
        next[0] = next[7] = 0;
        for (int i = 1; i < 7; i++) {
            next[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
        }
        return next;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [0,1,0,1,1,0,0,1]\n7\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,0,0,1,0,0,1,0]\n1000000000\n
 * // @lcpr case=end
 * 
 */
