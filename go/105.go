// 105. Construct Binary Tree from Preorder and Inorder Traversal

// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

// Example 1:


// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]
// Example 2:

// Input: preorder = [-1], inorder = [-1]
// Output: [-1]
 

// Constraints:

// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder and inorder consist of unique values.
// Each value of inorder also appears in preorder.
// preorder is guaranteed to be the preorder traversal of the tree.
// inorder is guaranteed to be the inorder traversal of the tree.

// Runtime 1 ms Beats 63.75%
// Memory 5.76 MB Beats 91.82%
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func buildTree(preorder []int, inorder []int) *TreeNode {
    root := &TreeNode{Val: preorder[0]}
    inorderIndex := slices.IndexFunc(inorder, func(item int) bool { return item == preorder[0]})
    if inorderIndex > 0 {
        root.Left = buildTree(preorder[1:inorderIndex + 1], inorder[:inorderIndex])
    }
    if inorderIndex < len(inorder) - 1 {
        root.Right = buildTree(preorder[inorderIndex + 1:], inorder[inorderIndex + 1:])
    }
    return root
}