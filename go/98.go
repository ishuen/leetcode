// 98. Validate Binary Search Tree

// Given the root of a binary tree, determine if it is a valid binary search tree (BST).

// A valid BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
 

// Example 1:


// Input: root = [2,1,3]
// Output: true
// Example 2:


// Input: root = [5,1,4,null,null,3,6]
// Output: false
// Explanation: The root node's value is 5 but its right child's value is 4.
 

// Constraints:

// The number of nodes in the tree is in the range [1, 104].
// -231 <= Node.val <= 231 - 1

// Runtime 0 ms Beats 100.00%
// Memory 7.30 MB Beats 48.28%
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isValidBST(root *TreeNode) bool {
    var prev *TreeNode
    isValid := true
    var dfs func(root *TreeNode)
    dfs = func(root *TreeNode) {
        if root == nil || isValid == false {
            return
        }
        dfs(root.Left)
        if prev != nil && prev.Val >= root.Val {
            isValid = false
            return
        }
        prev = root
        dfs(root.Right)
    }
    dfs(root)
    return isValid
}