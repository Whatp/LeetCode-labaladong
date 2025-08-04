/*
 * @lc app=leetcode.cn id=173 lang=java
 * @lcpr version=30202
 *
 * [173] 二叉搜索树迭代器
 */

// @lc code=start
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
import java.util.*;

class BSTIterator {

    private TreeNode node;
    Deque<TreeNode> res = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        node = root;
    }

    public int next() {
        while (node != null) {
            res.push(node);
            node = node.left;
        }

        node = res.pop();
        int ret = node.val;
        node = node.right;
        return ret;
    }

    public boolean hasNext() {
        return node != null || !res.isEmpty();
    }
}


/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end



