// 445. Add Two Numbers II
// You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//
//
// Example 1:
//
//
// Input: l1 = [7,2,4,3], l2 = [5,6,4]
// Output: [7,8,0,7]
// Example 2:
//
// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [8,0,7]
// Example 3:
//
// Input: l1 = [0], l2 = [0]
// Output: [0]
//
//
// Constraints:
//
// The number of nodes in each linked list is in the range [1, 100].
// 0 <= Node.val <= 9
// It is guaranteed that the list represents a number that does not have leading zeros.
//
// Runtime 2 ms Beats 100%
// Memory 43 MB Beats 22.53%
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
        ListNode reverse1 = reverse(l1);
        ListNode reverse2 = reverse(l2);
        ListNode cur1 = reverse1;
        ListNode cur2 = reverse2;
        int next = 0;
        while (cur1 != null && cur2 != null) {
            cur1.val = cur1.val + cur2.val + next;
            if (cur1.val >= 10) {
                next = cur1.val / 10;
                cur1.val = cur1.val % 10;
            } else {
                next = 0;
            }
            if (cur1.next == null && cur2.next != null) {
                cur1.next = cur2.next;
                cur2.next = null;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while (cur1 != null && next > 0) {
            cur1.val = cur1.val + next;
            if (cur1.val >= 10) {
                    next = cur1.val / 10;
                    cur1.val = cur1.val % 10;
            } else {
                next = 0;
            }
            cur1 = cur1.next;
        }
        ListNode head = reverse(reverse1);
        if (next > 0) {
            ListNode remained = new ListNode(next);
            remained.next = head;
            head = remained;
        }
        return head;
    }
    private ListNode reverse(ListNode node) {
        ListNode cur = node.next;
        if (cur == null) return node;
        node.next = null;
        if (cur.next != null) {
            ListNode temp = cur.next;
            while (temp != null) {
                cur.next = node;
                node = cur;
                cur = temp;
                temp = temp.next;
            }
        }
        cur.next = node;
        return cur;
    }
}

// Runtime 5 ms Beats 36.84%
// Memory 42.6 MB Beats 70.46%
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int next = 0;
        ListNode head = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int val = stack1.pop() + stack2.pop() + next;
            ListNode temp = new ListNode(val % 10);
            next = val / 10;
            if (head != null) {
                temp.next = head;
            }
            head = temp;
        }
        while (!stack1.isEmpty()) {
            int val = stack1.pop() + next;
            ListNode temp = new ListNode(val % 10);
            next = val / 10;
            if (head != null) {
                temp.next = head;
            }
            head = temp;
        }
        while (!stack2.isEmpty()) {
            int val = stack2.pop() + next;
            ListNode temp = new ListNode(val % 10);
            next = val / 10;
            if (head != null) {
                temp.next = head;
            }
            head = temp;
        }
        if (next > 0) {
            ListNode temp = new ListNode(next);
            temp.next = head;
            head = temp;
        }
        return head;
    }
}