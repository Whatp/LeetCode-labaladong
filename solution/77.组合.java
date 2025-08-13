/*
 * @lc app=leetcode.cn id=77 lang=java
 * @lcpr version=30202
 *
 * [77] 组合
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(res, path, 1, n, k);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int index, int n, int k) {
        // base case
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 可以剪枝优化，剩余数字不足的时候，直接跳过
        // for (int i = index; i <= n - (k - path.size()) + 1; i++)
        for (int i = index; i <= n; i++) {
            path.add(i);
            dfs(res, path, i + 1, n, k);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 4\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 1\n1\n
 * // @lcpr case=end
 * 
 */
