// 101. Symmetric Tree

// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

// Example 1:


// Input: root = [1,2,2,3,4,4,3]
// Output: true
// Example 2:


// Input: root = [1,2,2,null,3,null,3]
// Output: false
 

// Constraints:

// The number of nodes in the tree is in the range [1, 1000].
// -100 <= Node.val <= 100
 

// Follow up: Could you solve it both recursively and iteratively?

// Runtime 0 ms Beats 100.00%
// Memory 4.70 MB Beats 100.00%
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isSymmetric(root *TreeNode) bool {
    return isLeftRightSym(root.Left, root.Right)
}

func isLeftRightSym(left, right *TreeNode) bool {
    if left == nil && right == nil {
        return true
    }
    if (left == nil && right != nil) || (left != nil && right == nil) || (left != nil && right != nil && left.Val != right.Val) {
        return false
    }
    isLSame := isLeftRightSym(left.Left, right.Right)
    isRSame := isLeftRightSym(left.Right, right.Left)
    return isLSame && isRSame
}