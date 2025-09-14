/*
 * @lc app=leetcode.cn id=63 lang=java
 * @lcpr version=30203
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] != 1) {
            dp[0][0] = 1;
        } else {
            dp[0][0] = 0;
        }
        // 这里要注意，只能从上方或者左侧过来的情况
        // 前面只要有个障碍物了，后面的都是0，这个等式是为了继承
        // 上方或者左侧的数值
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }  else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[0,0,0],[0,1,0],[0,0,0]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[0,1],[0,0]]\n
 * // @lcpr case=end
 * 
 */
