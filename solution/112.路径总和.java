/*
 * @lc app=leetcode.cn id=112 lang=java
 * @lcpr version=30202
 *
 * [112] 路径总和
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

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
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return (hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val));

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // 用两个栈
        Deque<TreeNode> node = new LinkedList<>();
        Deque<Integer> sum = new LinkedList<>();
        
        node.offer(root);
        sum.offer(targetSum - root.val);
        while (!node.isEmpty()) {
            TreeNode p = node.poll();
            Integer num = sum.poll();

            if (p.left == null && p.right == null && num == 0) {
                return true;
            }
            if (p.left != null) {
                node.offer(p.left);
                sum.offer(num - p.left.val);
            }

            if (p.right != null) {
                node.offer(p.right);
                sum.offer(num - p.right.val);
            }
        }
        return false;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [5,4,8,11,null,13,4,7,2,null,null,null,1]\n22\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3]\n5\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n0\n
 * // @lcpr case=end
 * 
 */
