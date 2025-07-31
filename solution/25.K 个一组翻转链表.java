/*
 * @lc app=leetcode.cn id=25 lang=java
 * @lcpr version=30202
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        
        // 首先检查是否有k个节点
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            if (end == null) return head; // 不足k个，不反转
            end = end.next;
        }
        
        // 反转前k个节点
        ListNode newHead = reverse(head, end);
        
        // 递归处理剩余部分并连接
        head.next = reverseKGroup(end, k);
        
        return newHead;
    }

    /**
     * 反转从start到end之间的节点（不包括end）
     */
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode curr = start;
        
        while (curr != end) {
            ListNode next = curr.next; // 保存下一个节点
            curr.next = prev;         // 反转指针
            prev = curr;              // 前移prev
            curr = next;              // 前移curr
        }
        
        return prev; // 返回新的头节点
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,4,5]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3,4,5]\n3\n
 * // @lcpr case=end
 * 
 */
