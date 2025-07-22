3/*
 * @lc app=leetcode.cn id=54 lang=java
 * @lcpr version=30201
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // 向右
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            
            // 向下
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            // 如果只有一行了，就不能 bottom--了，要不然会错误的收缩边界 bottom
            if (top <= bottom) {  // 检查是否还有行
                // 向左
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            if (left <= right) {  // 检查是否还有列
                // 向上
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,2,3],[4,5,6],[7,8,9]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,2,3,4],[5,6,7,8],[9,10,11,12]]\n
 * // @lcpr case=end
 * 
 */
