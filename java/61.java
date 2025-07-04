// 61. Rotate List
//
// Given the head of a linked list, rotate the list to the right by k places.
//
//
//
// Example 1:
//
//
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]
// Example 2:
//
//
// Input: head = [0,1,2], k = 4
// Output: [2,0,1]
//
//
// Constraints:
//
// The number of nodes in the list is in the range [0, 500].
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109
//
// Runtime 0 ms Beats 100.00% of users with Java
// Memory 42.47 MB Beats 25.75% of users with Java
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
        if (k == 0 || head == null) return head;
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        int size = 0;
        for (int i = 0; i < k; i++) {
            if (pointer1.next != null) {
                pointer1 = pointer1.next;
                size++;
            } else {
                size = i + 1;
                pointer1 = head;
                break;
            }
        }
        k = k % size;
        for (int i = 0; i < k; i++) {
            if (pointer1.next != null) {
                pointer1 = pointer1.next;
            }
        }

        while (pointer1.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        if (pointer2.next == null) return head;
        ListNode newHead = pointer2.next; 
        pointer2.next = null;
        pointer1.next = head;
        return newHead;
    }
}