/*
 * @lc app=leetcode.cn id=48 lang=java
 * @lcpr version=30201
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        /**
         * 先沿着对角线旋转矩阵，再反转
         */
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        /**
         * 反转每一行
         */
        for (int[] is : matrix) {
            int i = 0, j = n - 1;
            while (i < j) {
                int temp = is[i];
                is[i] = is[j];
                is[j] = temp;
                i++;
                j--;
            }
        }
        
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,2,3],[4,5,6],[7,8,9]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]\n
 * // @lcpr case=end
 * 
 */
