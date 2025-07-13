// 92. Reverse Linked List II

// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

// Example 1:


// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]
// Example 2:

// Input: head = [5], left = 1, right = 1
// Output: [5]
 

// Constraints:

// The number of nodes in the list is n.
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n
 

// Follow up: Could you do it in one pass?

// Runtime 0 ms Beats 100.00%
// Memory 4.12 MB Beats 9.66%
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseBetween(head *ListNode, left int, right int) *ListNode {
    if left == right {
        return head
    }
    dummyHead := &ListNode{Next: head}
    index := 0
    cur := dummyHead
    for ; index < left - 1; index++ {
        cur = cur.Next
    }
    prev := cur
    cur = cur.Next
    index++
    first := cur
    tempNext := cur
    for ; index <= right; index++{
        tempNext = cur.Next
        cur.Next = prev.Next
        prev.Next = cur
        cur = tempNext
    }
    first.Next = cur
    return dummyHead.Next
}