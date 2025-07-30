/*
 * @lc app=leetcode.cn id=92 lang=java
 * @lcpr version=30202
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right)
            return head;
        // 哑节点来处理 m = 1 的情况，因为 m = 1 的时候是从头节点开始反转，前面没有节点的话我们没法反转
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;

        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        /**
         * 我们要找到pre、start（left）、then，然后反转
         */
        ListNode start = pre.next;
        ListNode then = start.next;
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;
    }

    public ListNode reverseBetween1(ListNode head, int left, int right) {
        
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,4,5]\n2\n4\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5]\n1\n1\n
 * // @lcpr case=end
 * 
 */
