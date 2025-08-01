/*
 * @lc app=leetcode.cn id=86 lang=java
 * @lcpr version=30202
 *
 * [86] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        /**
         * 可以创建两个链表分别存储小于和大于等于的节点，最后合并
         */
        ListNode preHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);
        ListNode pre = preHead, after = afterHead;

        while (head != null) {
            if (head.val < x) {
                pre.next = head;
                pre = pre.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        // 有环？
        after.next = null;
        pre.next = afterHead.next;
        return preHead.next;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,4,3,2,5,2]\n3\n
// @lcpr case=end

// @lcpr case=start
// [2,1]\n2\n
// @lcpr case=end

 */

