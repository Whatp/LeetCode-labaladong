/*
 * @lc app=leetcode.cn id=79 lang=java
 * @lcpr version=30202
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        // 直接暴力
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs (char[][] board, String word,int x, int y, int index) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(index)) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        char temp = board[x][y];
        board[x][y] = '#';
        boolean flag = dfs(board, word, x + 1, y, index + 1) ||
                        dfs(board, word, x, y + 1, index + 1) || 
                        dfs(board, word, x - 1, y, index + 1) ||
                        dfs(board, word, x, y - 1, index + 1);

        board[x][y] = temp;
        return flag;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"\n
// @lcpr case=end

// @lcpr case=start
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"SEE"\n
// @lcpr case=end

// @lcpr case=start
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCB"\n
// @lcpr case=end

 */

