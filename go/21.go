// 21. Merge Two Sorted Lists

// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

// Return the head of the merged linked list.

 

// Example 1:


// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]
// Example 2:

// Input: list1 = [], list2 = []
// Output: []
// Example 3:

// Input: list1 = [], list2 = [0]
// Output: [0]
 

// Constraints:

// The number of nodes in both lists is in the range [0, 50].
// -100 <= Node.val <= 100
// Both list1 and list2 are sorted in non-decreasing order.

// Runtime 0 ms Beats 100.00%
// Memory 4.46 MB Beats 41.04%
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
    if list1 == nil {
        return list2
    } else if list2 == nil {
        return list1
    }
    var head *ListNode
    if list1.Val <= list2.Val {
        head = list1
        list1 = list1.Next
    } else {
        head = list2
        list2 = list2.Next
    }
    pointer := head
    for ; list1 != nil && list2 != nil; {
        if list1.Val <= list2.Val {
            pointer.Next = list1
            list1 = list1.Next
        } else {
            pointer.Next = list2
            list2 = list2.Next
        }
        pointer = pointer.Next
    }
    if list1 != nil {
        pointer.Next = list1
    } else {
        pointer.Next = list2
    }
    return head
}