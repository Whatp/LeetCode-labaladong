/*
 * @lc app=leetcode.cn id=129 lang=java
 * @lcpr version=30202
 *
 * [129] 求根节点到叶节点数字之和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        /**
         * 深度优先遍历
         */
        return getSum(root, 0);

    }

    private int getSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }

        return getSum(root.left, sum) + getSum(root.right, sum);

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [4,9,0,5,1]\n
 * // @lcpr case=end
 * 
 */
