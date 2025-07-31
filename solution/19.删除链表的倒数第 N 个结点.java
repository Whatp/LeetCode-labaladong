/*
 * @lc app=leetcode.cn id=19 lang=java
 * @lcpr version=30202
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // 快指针先移动n+1步
        for (int i = 0; i <= n; i++) {
            if (fast == null) return head; // n大于链表长度
            fast = fast.next;
        }
        
        // 同时移动快慢指针
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // 删除节点
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,4,5]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n1\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2]\n1\n
 * // @lcpr case=end
 * 
 */
