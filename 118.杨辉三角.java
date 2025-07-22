/*
 * @lc app=leetcode.cn id=118 lang=java
 * @lcpr version=30201
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) {
            return res;
        }
        // 先把第一层装进去作为 base case
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);
        // 开始一层一层生成，装入 res
        for (int i = 2; i <= numRows; i++) {
            List<Integer> prevRow = res.get(res.size() - 1);
            res.add(generateNextRow(prevRow));
        }
        return res;
    }

    List<Integer> generateNextRow(List<Integer> prevRow) {
        List<Integer> nextRow = new ArrayList<>();
        nextRow.add(1);
        for (int i = 1; i < prevRow.size(); i++) {
            nextRow.add(prevRow.get(i - 1) + prevRow.get(i));
        }
        nextRow.add(1);
        return nextRow;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 5\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

