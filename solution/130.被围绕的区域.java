/*
 * @lc app=leetcode.cn id=130 lang=java
 * @lcpr version=30202
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {

        if (board.length == 0 || board == null)
            return;

        // 把所有和边界相连的'O'变成'#'
        for (int i = 0; i <= board.length - 1; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }

        // 接下来的才是真正被包围了，把 O 变成 X，然后再把 # 变成 O
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        } 

    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1
                || board[i][j] == 'X' || board[i][j] == '#')
            return;

        board[i][j] = '#';
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * //
 * [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [["X"]]\n
 * // @lcpr case=end
 * 
 */
