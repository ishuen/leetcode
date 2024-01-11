// 2. Add Two Numbers
//
// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//
//
// Example 1:
//
//
// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.
// Example 2:
//
// Input: l1 = [0], l2 = [0]
// Output: [0]
// Example 3:
//
// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: [8,9,9,9,0,0,0,1]
//
//
// Constraints:
//
// The number of nodes in each linked list is in the range [1, 100].
// 0 <= Node.val <= 9
// It is guaranteed that the list represents a number that does not have leading zeros.
//
// Runtime 1 ms Beats 100.00% of users with Java
// Memory 44.66 MB Beats 10.77% of users with Java
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode p = dummyHead;
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        int extra = 0;
        while (pointer1 != null && pointer2 != null) {
            extra += pointer1.val + pointer2.val;
            ListNode cur = new ListNode(extra % 10);
            extra = extra / 10;
            p.next = cur;
            p = p.next;
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        while (pointer1 != null) {
            extra += pointer1.val;
            ListNode cur = new ListNode(extra % 10);
            extra = extra / 10;
            p.next = cur;
            p = p.next;
            pointer1 = pointer1.next;
        }
        while (pointer2 != null) {
            extra += pointer2.val;
            ListNode cur = new ListNode(extra % 10);
            extra = extra / 10;
            p.next = cur;
            p = p.next;
            pointer2 = pointer2.next;
        }
        if (extra != 0) {
            ListNode cur = new ListNode(extra);
            p.next = cur;
        }
        return dummyHead.next;
    }
}
