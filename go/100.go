// 100. Same Tree

// Given the roots of two binary trees p and q, write a function to check if they are the same or not.

// Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

// Example 1:


// Input: p = [1,2,3], q = [1,2,3]
// Output: true
// Example 2:


// Input: p = [1,2], q = [1,null,2]
// Output: false
// Example 3:


// Input: p = [1,2,1], q = [1,1,2]
// Output: false
 

// Constraints:

// The number of nodes in both trees is in the range [0, 100].
// -104 <= Node.val <= 104

// Runtime 0 ms Beats 100.00%
// Memory 4.09 MB Beats 99.40%
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isSameTree(p *TreeNode, q *TreeNode) bool {
    if p == nil && q == nil {
        return true
    }
    if (p != nil && q == nil) || (p == nil && q != nil) || (p != nil && q != nil && p.Val != q.Val) {
        return false
    }
    isSameLeft := isSameTree(p.Left, q.Left)
    isSameRight := isSameTree(p.Right, q.Right)
    return isSameLeft && isSameRight
}