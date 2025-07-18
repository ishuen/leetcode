// 106. Construct Binary Tree from Inorder and Postorder Traversal

// Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

// Example 1:


// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]
// Example 2:

// Input: inorder = [-1], postorder = [-1]
// Output: [-1]
 

// Constraints:

// 1 <= inorder.length <= 3000
// postorder.length == inorder.length
// -3000 <= inorder[i], postorder[i] <= 3000
// inorder and postorder consist of unique values.
// Each value of postorder also appears in inorder.
// inorder is guaranteed to be the inorder traversal of the tree.
// postorder is guaranteed to be the postorder traversal of the tree.

// Runtime 0 ms Beats 100.00%
// Memory 5.96 MB Beats 71.60%

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func buildTree(inorder []int, postorder []int) *TreeNode {
    root := &TreeNode{Val: postorder[len(postorder) - 1]}
    inorderIndex := slices.IndexFunc(inorder, func(item int) bool {
        return item == postorder[len(postorder) - 1]
    })
    if inorderIndex != 0 {
        root.Left = buildTree(inorder[:inorderIndex], postorder[0:inorderIndex])
    }
    if inorderIndex < len(inorder) - 1 {
        root.Right = buildTree(inorder[inorderIndex + 1:], postorder[inorderIndex:len(postorder) - 1])
    }
    return root
}