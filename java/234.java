// 234. Palindrome Linked List
// Given a singly linked list, determine if it is a palindrome.
//
// Example 1:
//
// Input: 1->2
// Output: false
// Example 2:
//
// Input: 1->2->2->1
// Output: true
//
// Runtime: 1 ms, faster than 95.21% of Java online submissions for Palindrome Linked List.
// Memory Usage: 42.1 MB, less than 49.64% of Java online submissions for Palindrome Linked List.
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
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode center = head;
        ListNode end = head;
        while (end.next != null) {
            end = end.next;
            if (end.next != null) {
                end = end.next;
            }
            center = center.next;
        }
        ListNode cur = center;
        ListNode prev = null;
        ListNode next;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        cur = prev;
        ListNode cur2 = head;
        while (cur != null && cur2 != null) {
            if (cur.val != cur2.val) return false;
            cur = cur.next;
            cur2 = cur2.next;
        }
        return true;
    }
}