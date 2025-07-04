// 82. Remove Duplicates from Sorted List II
// Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
//
// Example 1:
//
//
// Input: head = [1,2,3,3,4,4,5]
// Output: [1,2,5]
// Example 2:
//
//
// Input: head = [1,1,1,2,3]
// Output: [2,3]
//
//
// Constraints:
//
// The number of nodes in the list is in the range [0, 300].
// -100 <= Node.val <= 100
// The list is guaranteed to be sorted in ascending order.
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List II.
// Memory Usage: 38.5 MB, less than 45.34% of Java online submissions for Remove Duplicates from Sorted List II.
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head; // 1
        ListNode cur = head; // 1
        ListNode last = cur; // 1
        ListNode prev = dummyHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                prev.next = last.next;
                cur = last.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
            last = cur;
        }
        return dummyHead.next;
    }
}

// dummy head as prev
// head is unique -> go next
// head is duplicated -> find the next new value and set it as head

// prev => prev.next = last.next
// cur: 1st occurance => cur = last.next
// last: last occurance (init: cur)
// while last == last.next -> go next

