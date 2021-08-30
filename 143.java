// 143. Reorder List
// You are given the head of a singly linked-list. The list can be represented as:
//
// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:
//
// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.
//
//
//
// Example 1:
//
//
// Input: head = [1,2,3,4]
// Output: [1,4,2,3]
// Example 2:
//
//
// Input: head = [1,2,3,4,5]
// Output: [1,5,2,4,3]
//
//
// Constraints:
//
// The number of nodes in the list is in the range [1, 5 * 104].
// 1 <= Node.val <= 1000
//
// Runtime: 2 ms, faster than 41.94% of Java online submissions for Reorder List.
// Memory Usage: 50.1 MB, less than 6.94% of Java online submissions for Reorder List.
// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// Runtime: 2 ms, faster than 41.94% of Java online submissions for Reorder List.
// Memory Usage: 49.7 MB, less than 12.97% of Java online submissions for Reorder List.
class Solution {
    public void reorderList(ListNode head) {
        ListNode cur = head;
        ListNode mid = head;
        ListNode last = null;
        int count = 0;
        while (cur != null) {
            if (count % 2 == 0) {
                last = mid;
                mid = mid.next;
            }
            cur = cur.next;
            count++;
        }
        last.next = null;
        if (mid == null) return;
        cur = mid.next;
        ListNode next;
        mid.next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = mid;
            mid = cur;
            cur = next;
        }
        cur = head;
        ListNode pointer;
        ListNode nextMid;
        while (cur != null && mid != null) {
            pointer = cur.next;
            nextMid = mid.next;
            mid.next = pointer;
            cur.next = mid;
            cur = pointer;
            mid = nextMid;
        }
    }
}