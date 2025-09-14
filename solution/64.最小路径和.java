/*
 * @lc app=leetcode.cn id=64 lang=java
 * @lcpr version=30201
 *
 * [64] 最小路径和
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    int memo[][];
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        memo = new int[m][n];
        for (int[] rows : memo) {
            Arrays.fill(rows, -1);
        }

        return dp(m - 1, n - 1, grid);
        
    }
    /**
     * 到当前的位置(i, j)只能从上面或者左边过来，然后再加上当前的值
     * @param i
     * @param j
     * @return
     */
    int dp(int i, int j, int[][] grid) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        memo[i][j] = Math.min(dp(i - 1, j, grid), dp(i, j - 1, grid)) + grid[i][j];
        return memo[i][j];
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,3,1],[1,5,1],[4,2,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,2,3],[4,5,6]]\n
// @lcpr case=end

 */

