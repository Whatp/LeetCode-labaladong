/*
 * @lc app=leetcode.cn id=212 lang=java
 * @lcpr version=30202
 *
 * [212] 单词搜索 II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String string : words) {
            if (isExist(board, string)) {
                res.add(string);
            }
        }
        return res;
    }

    public boolean isExist(char[][] board, String words) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String words, int i, int j, int k) {
        // base case
        if (k == words.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words.charAt(k)) {
            return false;
        }

        // 记录并且标记已经访问了
        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = dfs(board, words, i + 1, j, k + 1) ||
                        dfs(board, words, i - 1, j, k + 1) ||
                        dfs(board, words, i, j + 1, k + 1) ||
                        dfs(board, words, i , j - 1, k + 1);

        // 恢复现场
        board[i][j] = temp;
        return found;

    }
}
// @lc code=end



/*
// @lcpr case=start
// [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n\n["oath","pea","eat","rain"]\n
// @lcpr case=end

// @lcpr case=start
// [["a","b"],["c","d"]]\n["abcb"]\n
// @lcpr case=end

 */

