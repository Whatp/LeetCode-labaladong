/*
 * @lc app=leetcode.cn id=61 lang=java
 * @lcpr version=30202
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        /**
         * (k + 数组下标i) % 数组长度 就是新的位置
         */
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int[] a = new int[length];
        int[] b = new int[length];
        temp = head;
        for (int i = 0; i < b.length; i++) {
            a[i] = temp.val;
            temp = temp.next;
        }

        for (int i = 0; i < b.length; i++) {
            b[(i + k) % length] = a[i];
        }

        ListNode newHead = new ListNode(0);
        ListNode temp2 = newHead;
        for (int i = 0; i < b.length; i++) {
            ListNode curr = new ListNode(b[i]);
            temp2.next = curr;
            temp2 = temp2.next;
        }
        return newHead.next;

    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n2\n
// @lcpr case=end

// @lcpr case=start
// [0,1,2]\n4\n
// @lcpr case=end

 */

