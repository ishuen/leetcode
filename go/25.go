// 25. Reverse Nodes in k-Group

// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

// You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

// Example 1:


// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]
// Example 2:


// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]
 

// Constraints:

// The number of nodes in the list is n.
// 1 <= k <= n <= 5000
// 0 <= Node.val <= 1000
 

// Follow-up: Can you solve the problem in O(1) extra memory space?

// Runtime 0 ms Beats 100.00%
// Memory 5.36 MB Beats 86.91%
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseKGroup(head *ListNode, k int) *ListNode {
    if k == 1 {
        return head
    }
    dummyHead := &ListNode{Next: head}
    tempHead := dummyHead
    first := tempHead.Next
    for ; first != nil; {
        p1 := first
        for i := 0; i < k; i++ {
            if p1 == nil {
                return dummyHead.Next
            }
            p1 = p1.Next
        }
        cur := first
        tempNext := cur
        for i := 0; i < k; i++ {
            if cur == nil {
                first.Next = nil
                return dummyHead.Next
            }
            tempNext = cur.Next
            cur.Next = tempHead.Next
            tempHead.Next = cur
            if (i == k - 1) {
                tempHead = cur
            }
            cur = tempNext
        }
        first.Next = p1
        tempHead = first
        first = first.Next
    }
    return dummyHead.Next
}