// 107. Binary Tree Level Order Traversal II

// Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: [[15,7],[9,20],[3]]
// Example 2:

// Input: root = [1]
// Output: [[1]]
// Example 3:

// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 2000].
// -1000 <= Node.val <= 1000

// Runtime 0 ms Beats 100.00%
// Memory 4.90 MB Beats 84.09%
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func levelOrderBottom(root *TreeNode) [][]int {
    output := [][]int{}
    if root == nil {
        return output
    }
    stack := []*TreeNode{root}
    for ; len(stack) > 0; {
        size := len(stack)
        list := []int{}
        for i := 0; i < size; i++ {
            node := stack[i]
            if node.Left != nil {
                stack = append(stack, node.Left)
            }
            if node.Right != nil {
                stack = append(stack, node.Right)
            }
            list = append(list, node.Val)
        }
        stack = stack[size:]
        output = slices.Insert(output, 0, list)
    }
    return output
}