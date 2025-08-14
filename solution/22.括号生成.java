/*
 * @lc app=leetcode.cn id=22 lang=java
 * @lcpr version=30202
 *
 * [22] 括号生成
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(list, sb, n, n);
        return list;
    }

    private void dfs(List<String> list, StringBuilder sb, int left, int right) {

        // base case，从左往右开始放，肯定是右括号剩下的多
        if (left > right) return;
        if (left < 0 || right < 0) return;
        if (left == 0 && right == 0) {
            list.add(sb.toString());
            return;
        }

        sb.append("(");
        dfs(list, sb, left - 1, right);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(")");
        dfs(list, sb, left, right - 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}
// @lc code=end



/*
// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

