// 114. Flatten Binary Tree to Linked List

// Given the root of a binary tree, flatten the tree into a "linked list":

// The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
// The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 

// Example 1:


// Input: root = [1,2,5,3,4,null,6]
// Output: [1,null,2,null,3,null,4,null,5,null,6]
// Example 2:

// Input: root = []
// Output: []
// Example 3:

// Input: root = [0]
// Output: [0]
 

// Constraints:

// The number of nodes in the tree is in the range [0, 2000].
// -100 <= Node.val <= 100
 

// Follow up: Can you flatten the tree in-place (with O(1) extra space)?

// Runtime 0 ms Beats 100.00%
// Memory 4.91 MB Beats 17.03%
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func flatten(root *TreeNode)  {
    toList(root)
}

// first, last
func toList(root *TreeNode) (*TreeNode, *TreeNode) {
    first := root
    if root == nil {
        return nil, nil
    }
    if root.Left == nil && root.Right == nil {
        return root, root
    }
    var leftFirst, leftLast *TreeNode = nil, nil
    var rightFirst, rightLast *TreeNode = nil, nil
    if root.Left != nil {
        leftFirst, leftLast = toList(root.Left)
    } else {
        leftFirst = root
        leftLast = root
    }

    if root.Right != nil {
        rightFirst, rightLast = toList(root.Right)
        leftLast.Right = rightFirst
    } else {
        rightLast = leftLast
    }
    if leftFirst != root {
        first.Right = leftFirst
    }
    first.Left = nil
    return first, rightLast
}