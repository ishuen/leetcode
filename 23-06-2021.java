// Reverse Linked List II
// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
//
//
// Example 1:
//
//
// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]
// Example 2:
//
// Input: head = [5], left = 1, right = 1
// Output: [5]
//
//
// Constraints:
//
// The number of nodes in the list is n.
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n
//
//
// Follow up: Could you do it in one pass?

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        ListNode dummy = new ListNode();
        ListNode cur = head;
        ListNode beforeLeft = null;
        ListNode rightNode = null;
        ListNode leftNode = null;
        int counter = 1;
        while (cur != null) {
            if (counter < left) {
                if (counter == left - 1) {
                    beforeLeft = cur;
                }
                cur = cur.next;
            } else if (counter == left) {
                leftNode = cur;
            }
            if (counter >= left && counter <= right) {
                ListNode next = cur.next;
                cur.next = dummy.next;
                dummy.next = cur;
                cur = next;
                if (counter == right) {
                    rightNode = next;
                    break;  
                }
            }
            counter++;
        }
        if (left == 1) {
            head = dummy.next;
        } else {
            beforeLeft.next = dummy.next;
        }
        leftNode.next = rightNode;
        return head;
    }
}