// 148. Sort List

// Given the head of a linked list, return the list after sorting it in ascending order.

 

// Example 1:


// Input: head = [4,2,1,3]
// Output: [1,2,3,4]
// Example 2:


// Input: head = [-1,5,3,4,0]
// Output: [-1,0,3,4,5]
// Example 3:

// Input: head = []
// Output: []
 

// Constraints:

// The number of nodes in the list is in the range [0, 5 * 104].
// -105 <= Node.val <= 105
 

// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?


// Runtime 5 ms Beats 95.67%
// Memory 9.60 MB Beats 40.55%
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func sortList(head *ListNode) *ListNode {
    if head == nil || head.Next == nil {
        return head
    }
    fastNode := head
    slowNode := head
    prev := &ListNode{}
    for ;fastNode != nil && fastNode.Next != nil; {
        prev = slowNode
        slowNode = slowNode.Next
        fastNode = fastNode.Next.Next
    }
    prev.Next = nil
    return merge(sortList(head), sortList(slowNode)) 
}
func merge(first *ListNode, second *ListNode) *ListNode {
    dummyHead := &ListNode{}
    cur := dummyHead
    firstP := first
    secondP := second
    for ; firstP != nil && secondP != nil; {
        if firstP.Val < secondP.Val {
            cur.Next = firstP
            firstP = firstP.Next
        } else {
            cur.Next = secondP
            secondP = secondP.Next
        }
        cur = cur.Next
    }
    if firstP != nil {
        cur.Next = firstP
    } else if secondP != nil {
        cur.Next = secondP
    }
    return dummyHead.Next
}