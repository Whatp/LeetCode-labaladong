
/*
 * @lc app=leetcode.cn id=120 lang=java
 * @lcpr version=30203
 *
 * [120] 三角形最小路径和
 */
import java.util.*;;

// @lc code=start
class Solution {
    /**
     * 只能从上一个对应位置或者前一个位置过来
     * dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1]) + c[i][j]
     * 
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[2],[3,4],[6,5,7],[4,1,8,3]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[-10]]\n
 * // @lcpr case=end
 * 
 */
