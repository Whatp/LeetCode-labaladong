/*
 * @lc app=leetcode.cn id=124 lang=java
 * @lcpr version=30202
 *
 * [124] 二叉树中的最大路径和
 */

// @lc code=start

import javax.swing.tree.TreeNode;

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

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        // base case
        if (root == null)
            return 0;
        // 节点的最大贡献度，如果是负数就丢弃
        int leftGain = Math.max(dfs(root.left), 0);
        int rightGain = Math.max(dfs(root.right), 0);

        // 节点的最大贡献（最大路径）就是当前节点的值和该节点左右子树的值的和
        int pathSum = root.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, pathSum);

        // 只选择一棵子树，因为另一颗子树可能是负的
        return root.val + Math.max(leftGain, rightGain);
    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-10,9,20,null,null,15,7]\n
 * // @lcpr case=end
 * 
 */
