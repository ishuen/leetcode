// 2130. Maximum Twin Sum of a Linked List
//
// In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
//
// For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
// The twin sum is defined as the sum of a node and its twin.
//
// Given the head of a linked list with even length, return the maximum twin sum of the linked list.
//
//
//
// Example 1:
//
//
// Input: head = [5,4,2,1]
// Output: 6
// Explanation:
// Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
// There are no other nodes with twins in the linked list.
// Thus, the maximum twin sum of the linked list is 6.
// Example 2:
//
//
// Input: head = [4,2,2,3]
// Output: 7
// Explanation:
// The nodes with twins present in this linked list are:
// - Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
// - Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
// Thus, the maximum twin sum of the linked list is max(7, 4) = 7.
// Example 3:
//
//
// Input: head = [1,100000]
// Output: 100001
// Explanation:
// There is only one node with a twin in the linked list having twin sum of 1 + 100000 = 100001.
//
//
// Constraints:
//
// The number of nodes in the list is an even integer in the range [2, 105].
// 1 <= Node.val <= 105
//
// Runtime 22 ms Beats 10.78% of users with Java
// Memory 69.35 MB Beats 5.07% of users with Java
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
    public int pairSum(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode firstPointer = head.next;
        ListNode secondPointer = head;
        while (firstPointer != null && firstPointer.next != null) {
            firstPointer = firstPointer.next.next;
            secondPointer = secondPointer.next;
        }
        ListNode third = secondPointer.next;
        while (third != null) {
            stack.push(third);
            third = third.next;
        }
        ListNode start = head;
        int sum = 0;
        while (!stack.isEmpty()) {
            sum = Math.max(sum, start.val + stack.pop().val);
            start = start.next;
        }
        return sum;
    }
}


// Runtime 4 ms Beats 95.66% of users with Java
// Memory 63.58 MB Beats 63.28% of users with Java
class Solution {
    public int pairSum(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode firstPointer = head.next;
        ListNode secondPointer = head;
        while (firstPointer != null && firstPointer.next != null) {
            firstPointer = firstPointer.next.next;
            secondPointer = secondPointer.next;
        }
        ListNode third = secondPointer.next;
        ListNode fourth = third.next;
        third.next = null;
        secondPointer.next = null;
        while (fourth != null) {
            ListNode temp = fourth.next;
            fourth.next = third;
            third = fourth;
            fourth = temp;
        }
        
        int sum = 0;
        while (third != null && head != null) {
            sum = Math.max(sum, third.val + head.val);
            third = third.next;
            head = head.next;
        }
        return sum;
    }
}