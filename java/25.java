// 25. Reverse Nodes in k-Group
// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//
// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
//
// You may not alter the values in the list's nodes, only nodes themselves may be changed.
//
// Example 1:
//
//
// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]
// Example 2:
//
//
// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]
// Example 3:
//
// Input: head = [1,2,3,4,5], k = 1
// Output: [1,2,3,4,5]
// Example 4:
//
// Input: head = [1], k = 1
// Output: [1]
//
// Constraints:
//
// The number of nodes in the list is in the range sz.
// 1 <= sz <= 5000
// 0 <= Node.val <= 1000
// 1 <= k <= sz
//
// Runtime: 1 ms, faster than 20.41% of Java online submissions for Reverse Nodes in k-Group.
// Memory Usage: 42.6 MB, less than 5.31% of Java online submissions for Reverse Nodes in k-Group.
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        int count = 1;
        ListNode prevTail = dummy;
        while(cur != null) {
            if (count == k) {
                ListNode nextHead = cur.next;
                cur = head;
                ListNode node  = head.next;
                head.next = nextHead;
                while(node != nextHead) {
                    ListNode temp = node.next;
                    node.next = head;
                    head = node;
                    node = temp;
                }
                prevTail.next = head;
                prevTail = cur;
                head = nextHead;
                cur = nextHead;
                count = 1;
            } else {
                cur = cur.next;
                count++;
            }
        }
        return dummy.next;
    }
}