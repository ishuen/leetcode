// 82. Remove Duplicates from Sorted List II

// Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

 

// Example 1:


// Input: head = [1,2,3,3,4,4,5]
// Output: [1,2,5]
// Example 2:


// Input: head = [1,1,1,2,3]
// Output: [2,3]

// Constraints:

// The number of nodes in the list is in the range [0, 300].
// -100 <= Node.val <= 100
// The list is guaranteed to be sorted in ascending order.

// Runtime 0 ms Beats 100.00%
// Memory 4.68 MB Beats 99.45%
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func deleteDuplicates(head *ListNode) *ListNode {
    if head == nil {
        return head
    }
    dummyHead := &ListNode{Val: -101, Next: head}
    counter := 0
    prev := dummyHead
    pointer := head
    curNum := head.Val
    for pointer != nil {
        if pointer.Val == curNum {
            counter++
        } else {
            if counter > 1 {
                prev.Next = pointer
            } else if counter == 1 {
                prev = prev.Next
            }
            counter = 1
            curNum = pointer.Val
        }
        pointer = pointer.Next
    }
    if counter > 1 {
        prev.Next = nil
    }
    return dummyHead.Next
}
