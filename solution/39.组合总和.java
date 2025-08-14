/*
 * @lc app=leetcode.cn id=39 lang=java
 * @lcpr version=30202
 *
 * [39] 组合总和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * 关键在于怎么重复使用
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int sum = 0;
        dfs(res, path, 0, target, sum, candidates);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int index, int target, int sum, int[] candidates) {
        if(sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            // 剪枝
            if (sum + candidates[i] > target) {
                continue;
            }
            path.add(candidates[i]);
            // 应该传的是i,要是传index,就不变了
            dfs(res, path, i, target, sum + candidates[i], candidates);
            path.remove(path.size() - 1);
        }
        
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,3,6,7]\n7\n
// @lcpr case=end

// @lcpr case=start
// [2,3,5]\n8\n
// @lcpr case=end

// @lcpr case=start
// [2]\n1\n
// @lcpr case=end

 */

