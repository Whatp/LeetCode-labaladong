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
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        for (int[] rows : memo) {
            Arrays.fill(rows, -1);
        }
        return dp(grid, m - 1, n - 1);
    }

    int dp(int[][] grid, int i, int j) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        memo[i][j] = Math.min(dp(grid, i - 1, j), dp(grid, i, j - 1)) + grid[i][j];
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

