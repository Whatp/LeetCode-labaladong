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
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        // 初始化棋盘
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        dfs(res, board, 0, n);
        return res;
    }
    private void dfs(List<List<String>> res, char[][] board, int row, int n) {
        // base case
        if (row == n) {
            // 把baord转成List<String> 
            res.add(convert(board));
            return;
        }
        // 尝试在每一行放置皇后
        for (int col = 0; col < n; col++) {
            // 要检查是否可行
            if (check(board, row, col, n)) {
                board[row][col] = 'Q';
                dfs(res, board, row + 1, n);
                board[row][col] = '.';
            }
        }
    }
    private boolean check(char[][] board, int row, int col, int n) {
        // 检查列
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    // char[][]转成res类型
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

