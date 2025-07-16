// 61. Rotate List

// Given the head of a linked list, rotate the list to the right by k places.

 

// Example 1:


// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]
// Example 2:


// Input: head = [0,1,2], k = 4
// Output: [2,0,1]
 

// Constraints:

// The number of nodes in the list is in the range [0, 500].
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109

// Runtime 0 ms Beats 100.00%
// Memory 4.40 MB Beats 80.62%
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func rotateRight(head *ListNode, k int) *ListNode {
    if k == 0 || head == nil {
        return head
    }
    
    p1, p2 := head, head
    i := 0
    for ; i < k; i++ {
        if p1.Next == nil {
            p1 = head
            break
        } else {
            p1 = p1.Next
        }
    }
    if k > i {
        k = k % (i + 1)
        for i := 0; i < k; i++ {
            p1 = p1.Next
        }
    }
    for ; p1.Next != nil; {
        p1 = p1.Next
        p2 = p2.Next
    }
    if p1 == p2 {
        return head
    }
    newHead := p2.Next
    p2.Next = nil
    p1.Next = head
    return newHead
}