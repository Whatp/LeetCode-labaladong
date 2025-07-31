/*
 * @lc app=leetcode.cn id=82 lang=java
 * @lcpr version=30202
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        /**
         * 有重复的话就把重复的全部删除，而不是说只保留一个数字
         * 一个哑节点，但是这种方式不能处理三个节点重复或者更多节点重复
         */
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy, curr = head;

        while (curr != null) {
            // 值相等
            if (curr.next != null && curr.val == curr.next.val) {
                // 找到最后一个值不相等的节点
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                // 跳过所有的重复
                pre.next = curr.next;

            } else {
                pre = pre.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,3,4,4,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,1,1,2,3]\n
 * // @lcpr case=end
 * 
 */
