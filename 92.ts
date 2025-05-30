// 92. Reverse Linked List II
//
// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
//
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
//
// Runtime 0 ms Beats 100.00%
// Memory 53.47 MB Beats 98.93%
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

function reverseBetween(head: ListNode | null, left: number, right: number): ListNode | null {
    if (!head) return null
    if (left == right) return head
    let anchorLeft = new ListNode(-501, head)
    let dummyHead = anchorLeft
    let count = 0
    while(anchorLeft.next != null && count + 1 !== left) {
        count++
        anchorLeft = anchorLeft.next
    }
    let tail = anchorLeft.next
    let current = anchorLeft.next
    let tempHead = new ListNode(-501)
    while (current != null && count + 1 != right) {
        count++
        let temp = current.next
        current.next = tempHead.next
        tempHead.next = current
        current = temp
    }
    tail.next = current.next
    anchorLeft.next = current
    current.next = tempHead.next
    return dummyHead.next
};