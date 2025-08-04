/*
 * @lc app=leetcode.cn id=114 lang=java
 * @lcpr version=30202
 *
 * [114] 二叉树展开为链表
 */

// @lc code=start

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        /**
         * 思路就是找到当前节点左子树的最右节点，并且要记录这个当前节点、最右节点的前驱，
         * 将这个节点的右指针指到当前节点的右指针，断开当前节点的右指针
         * 最后不能忘了当前节点移动
         */
        TreeNode curr = root;
        while (curr != null) {
            // 找到最右
            if (curr.left != null) {
                TreeNode l = curr.left;
                TreeNode pre = l;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = curr.right;
                curr.left = null;
                curr.right = l;
            }
            curr = curr.right;
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,5,3,4,null,6]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */

