// 110. Balanced Binary Tree

// Given a binary tree, determine if it is height-balanced.

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: true
// Example 2:


// Input: root = [1,2,2,3,3,null,null,4,4]
// Output: false
// Example 3:

// Input: root = []
// Output: true
 

// Constraints:

// The number of nodes in the tree is in the range [0, 5000].
// -104 <= Node.val <= 104

// Runtime 0 ms Beats 100.00%
// Memory 7.31 MB Beats 56.38%
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isBalanced(root *TreeNode) bool {
    if root == nil {
        return true
    }
    return getDepth(root) != -1
}

func getDepth(root *TreeNode) int {
    if root == nil {
        return 0
    }
    left := getDepth(root.Left)
    right := getDepth(root.Right)
    if left == -1 || right == -1 {
        return -1
    }
    if math.Abs(float64(left - right)) > 1 {
        return -1
    }
    return 1 + max(left, right)
}