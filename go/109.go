// 109. Convert Sorted List to Binary Search Tree

// Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height-balanced binary search tree.

 

// Example 1:


// Input: head = [-10,-3,0,5,9]
// Output: [0,-3,9,-10,null,5]
// Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
// Example 2:

// Input: head = []
// Output: []
 

// Constraints:

// The number of nodes in head is in the range [0, 2 * 104].
// -105 <= Node.val <= 105

// Runtime 0 ms Beats 100.00%
// Memory 7.89 MB Beats 70.51%
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func sortedListToBST(head *ListNode) *TreeNode {
    if head == nil {
        return nil
    }
    if head.Next == nil {
        return &TreeNode{Val: head.Val}
    }
    mid := getMid(head)
    root := &TreeNode{Val: mid.Val}
    left := sortedListToBST(head)
    right := sortedListToBST(mid.Next)
    root.Left = left
    root.Right = right
    return root
}

func getMid(head *ListNode) *ListNode {
    fast := head
    slow := head
    var prev *ListNode
    prev = nil
    for ; fast != nil && fast.Next != nil; {
        prev = slow
        slow = slow.Next
        fast = fast.Next.Next
    }
    prev.Next = nil
    return slow
}