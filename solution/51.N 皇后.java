/*
 * @lc app=leetcode.cn id=51 lang=java
 * @lcpr version=30202
 *
 * [51] N 皇后
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution { 
    /**
     * 尝试在每一行放置皇后,检查这一列、右上、左上是否有皇后了，如果有就不放，没有就放
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> res = new ArrayList<>();
        dfs(board, n, res, 0);

        return res;

    }

    private void dfs(char[][] board, int n, List<List<String>> res, int row) {

        // base case
        if (row == n) {
            // 返回值是List<String>，所以应该把char[][]转成List<String>
            res.add(convert(board));
            return;
        }

        // 尝试在每一行放一个皇后，判断能不能放
        for (int col = 0; col < n; col++) {
            if (check(board, row, col, n)) {
                board[row][col] = 'Q';
                dfs(board, n, res, row + 1);
                // 恢复现场
                board[row][col] = '.';
            }
        }
    }

    private boolean check(char[][] board, int row, int col, int n) {
        // 判断列有没有皇后
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 判断右上有没有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 判断左上有没有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> convert(char[][] board) {
        List<String> temp = new ArrayList<>();
        for (char[] ch : board) {
            temp.add(new String(ch));
        }
        return temp;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 4\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

