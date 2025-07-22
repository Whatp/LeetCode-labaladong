/*
 * @lc app=leetcode.cn id=289 lang=java
 * @lcpr version=30201
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
    public void gameOfLife(int[][] board) {
        /**
         * 在这个瞬间，每个位置是生是死已经固定了，
         * 不是它旁边的位置发生了变化之后，它再发生改变
         * 最简单的就是创建一个二维数组，遍历一遍之后在新的数组更新
         * 最后复制到原数组
         */
        int m = board.length, n = board[0].length;
        int[][] temp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = board[i][j];
            }
        }
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},{1, 0},
            {1, 1}, {1, -1}, {0, 1}, {0, -1}
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;
                for (int[] dir : directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && temp[x][y] == 1) {
                        live++;
                    }
                }
                if (temp[i][j] == 1) {
                    if (live < 2 || live > 3) {
                        board[i][j] = 0;
                    }
                }
                else {
                    if (live == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }

    }
}
// @lc code=end



/*
// @lcpr case=start
// [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,1],[1,0]]\n
// @lcpr case=end

 */

