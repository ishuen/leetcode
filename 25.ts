// 25. Reverse Nodes in k-Group
//
// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
//
// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
//
// You may not alter the values in the list's nodes, only nodes themselves may be changed.
//
//
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
//
//
// Constraints:
//
// The number of nodes in the list is n.
// 1 <= k <= n <= 5000
// 0 <= Node.val <= 1000
//
//
// Follow-up: Can you solve the problem in O(1) extra memory space?
//
// Runtime 0 ms Beats 100.00%
// Memory 60.18 MB Beats 62.10%
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function reverseKGroup(head: ListNode | null, k: number): ListNode | null {
    if (head == null || k == 1) return head
    let left = head
    let right = left
    let count = 1
    while (right != null && count < k) {
        right = right.next
        count++
    }
    if (right == null || count < k) return head
    let tempTail = new ListNode(-1, right.next)
    tempTail.next = reverseKGroup(tempTail.next, k)
    let tail = left
    let tempHead = new ListNode(-1, null)
    while (left != right) {
        let temp = left.next
        left.next = tempHead.next
        tempHead.next = left
        left = temp
    }
    right.next = tempHead.next
    tempHead.next = right
    tail.next = tempTail.next
    return tempHead.next
};