// 94. Binary Tree Inorder Traversal

// Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

// Example 1:

// Input: root = [1,null,2,3]

// Output: [1,3,2]

// Explanation:



// Example 2:

// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

// Output: [4,2,6,5,7,1,3,9,8]

// Explanation:



// Example 3:

// Input: root = []

// Output: []

// Example 4:

// Input: root = [1]

// Output: [1]

 

// Constraints:

// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
 

// Follow up: Recursive solution is trivial, could you do it iteratively?

// Runtime 0 ms Beats 100.00%
// Memory 4.02 MB Beats 83.37%
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func inorderTraversal(root *TreeNode) []int {
    output := []int{}
    var getList func(root *TreeNode)
    getList = func(root *TreeNode) {
        if root.Left != nil {
            getList(root.Left)
        }
        output = append(output, root.Val)
        if root.Right != nil {
            getList(root.Right)
        }
    }
    if root != nil {
        getList(root)
    }
    return output
}