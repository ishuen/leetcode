// 19. Remove Nth Node From End of List

// Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

// Example 1:


// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]
// Example 2:

// Input: head = [1], n = 1
// Output: []
// Example 3:

// Input: head = [1,2], n = 1
// Output: [1]
 

// Constraints:

// The number of nodes in the list is sz.
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
 

// Follow up: Could you do this in one pass?

// Runtime 0 ms Beats 100.00%
// Memory 4.15 MB Beats 46.97%
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeNthFromEnd(head *ListNode, n int) *ListNode {
    dummyHead := &ListNode{Next: head}
    prev := dummyHead
    cur := head
    last := head
    for i := 0; i < n; i++ {
        last = last.Next
    }
    for ; last != nil; {
        last = last.Next
        cur = cur.Next
        prev = prev.Next
    }
    prev.Next = cur.Next
    return dummyHead.Next
}
