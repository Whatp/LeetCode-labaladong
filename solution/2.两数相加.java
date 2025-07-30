/*
 * @lc app=leetcode.cn id=2 lang=java
 * @lcpr version=30202
 *
 * [2] 两数相加
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 输入和输出都是从个位到最高位
         * 在进行链表的操作时，建一个虚拟的头节点是一个比较好的方法
         * 在输出的时候输出虚拟头节点下一个节点就是结果
         */
        ListNode p1 = l1, p2 = l2;
        ListNode dymmy = new ListNode(-1);
        // 移动指针，负责构建新链表
        ListNode p = dymmy;
        int carry = 0; // 进位
        while (p1 != null || p2 != null || carry > 0) {
            int value = carry;
            if (p1 != null) {
                value += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                value += p2.val;
                p2 = p2.next;
            }
            carry = value / 10;
            value = value % 10;

            p.next = new ListNode(value);
            p = p.next;
        }

        return dymmy.next;

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,4,3]\n[5,6,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0]\n[0]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [9,9,9,9,9,9,9]\n[9,9,9,9]\n
 * // @lcpr case=end
 * 
 */
