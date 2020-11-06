// 206. Reverse Linked List
//   Reverse a singly linked list.
//
//   Example:
//
//   Input: 1->2->3->4->5->NULL
//   Output: 5->4->3->2->1->NULL
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
// Memory Usage: 38.9 MB, less than 15.88% of Java online submissions for Reverse Linked List.
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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode newHead = new ListNode(head.val);
        while (cur.next != null) {
            ListNode temp = new ListNode(cur.next.val);
            temp.next = newHead;
            newHead = temp;
            cur = cur.next;
        }
        return newHead;
    }
}