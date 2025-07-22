/*
 * @lc app=leetcode.cn id=73 lang=java
 * @lcpr version=30201
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        /**
         * 如果有0，这一行、一列都置零
         * 记录一下出现的行号和列号
         */
        int m = matrix.length, n = matrix[0].length;
        boolean[]row = new boolean[m];
        boolean[]col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,1,1],[1,0,1],[1,1,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,1,2,0],[3,4,5,2],[1,3,1,5]]\n
// @lcpr case=end

 */

