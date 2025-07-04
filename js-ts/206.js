// 206. Reverse Linked List
//
// Given the head of a singly linked list, reverse the list, and return the reversed list.
//
//
//
// Example 1:
//
//
// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]
// Example 2:
//
//
// Input: head = [1,2]
// Output: [2,1]
// Example 3:
//
// Input: head = []
// Output: []
//
//
// Constraints:
//
// The number of nodes in the list is the range [0, 5000].
// -5000 <= Node.val <= 5000
//
//
// Runtime 53 ms Beats 72.42% of users with JavaScript
// Memory 44.04 MB Beats 67.85% of users with JavaScript
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
    if (!head) return head;
    let dummyHead = new ListNode();
    let next = head.next;
    head.next = null;
    dummyHead.next = head;
    while (next != null) {
        let temp = next.next;
        next.next = dummyHead.next;
        dummyHead.next = next;
        next = temp;
    }
    return dummyHead.next;
};