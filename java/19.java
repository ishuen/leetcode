// 19. Remove Nth Node From End of List
// Given the head of a linked list, remove the nth node from the end of the list and return its head.
//
// Follow up: Could you do this in one pass?
//
// Example 1:
// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]
// Example 2:
//
// Input: head = [1], n = 1
// Output: []
// Example 3:
//
// Input: head = [1,2], n = 1
// Output: [1]
//
// Constraints:
// The number of nodes in the list is sz.
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
// Memory Usage: 36.8 MB, less than 79.79% of Java online submissions for Remove Nth Node From End of List.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode findLast = head;
        ListNode toRemove = head;
        ListNode prev = head;
        for (int i = 1; i < n; i++) {
            findLast = findLast.next;
        }
        if (findLast.next == null) {
            return head.next;
        }
        findLast = findLast.next;
        toRemove = toRemove.next;
        while (findLast.next != null) {
            findLast = findLast.next;
            toRemove = toRemove.next;
            prev = prev.next;
        }
        prev.next = toRemove.next;
        return head;
    }
}

// index = 0 -> rewrite the head
// index > 0 -> prev's next = target's next