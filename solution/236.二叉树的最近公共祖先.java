/*
 * @lc app=leetcode.cn id=236 lang=java
 * @lcpr version=30202
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 这个题的思路就是：假设root是LCA（最近公共祖先），不是根节点的意思
         * p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
         * p=root ，且 q 在 root 的左或右子树中；
         * q=root ，且 p 在 root 的左或右子树中；
         */
        if (root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,5,1,6,2,0,8,null,null,7,4]\n5\n1\n
// @lcpr case=end

// @lcpr case=start
// [3,5,1,6,2,0,8,null,null,7,4]\n5\n4\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n1\n2\n
// @lcpr case=end

 */

