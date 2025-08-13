/*
 * @lc app=leetcode.cn id=17 lang=java
 * @lcpr version=30202
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    String[] words = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        int n = digits.length();
        char[] path = new char[n];
        dfs(res, 0, path, digits.toCharArray());
        return res;
    }

    // 结果数组、索引、路径数组、数字
    private void dfs(List<String> res, int index, char[] path, char[] digits) {

        if (index == path.length) {
            res.add(new String(path));
            return;
        }

        String letters = words[digits[index] - '0'];
        for (char c : letters.toCharArray()) {
            // 这一步会覆盖掉，所以不显示回溯也没有问题
            path[index] = c;
            dfs(res, index + 1, path, digits);
            // 如果要回溯
            path[index] = '\0';
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "23"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // ""\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "2"\n
 * // @lcpr case=end
 * 
 */
