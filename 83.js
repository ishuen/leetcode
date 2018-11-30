// 83. Remove Duplicates from Sorted List
// Given a sorted linked list, delete all duplicates such that each element appear only once.
//
// Example 1:
//
// Input: 1->1->2
// Output: 1->2
// Example 2:
//
// Input: 1->1->2->3->3
// Output: 1->2->3

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */

// slow 88ms 14%
var deleteDuplicates = function(head) {
  var temp = head;
  while (temp != null && temp.next != null) {
    if (temp.val == temp.next.val) {
      temp.next = temp.next.next;
    } else {
      temp = temp.next;
    }
  }
  return head;
};

// fast 64ms 100%
var deleteDuplicates = function(head) {
  var temp = head;
  var temp2;
  if (temp != null) {
    temp2 = temp.next;
  }
  while (temp != null && temp2 != null) {
    if (temp.val == temp2.val) {
      temp2 = temp2.next;
      temp.next = temp2;
    } else {
      temp = temp2;
      temp2 = temp2.next;
    }
  }
  return head;
};