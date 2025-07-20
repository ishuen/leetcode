// 102. Binary Tree Level Order Traversal

// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]
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
// Memory 5.73 MB Beats 19.42%
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func levelOrder(root *TreeNode) [][]int {
    output := [][]int{}
    if root == nil {
        return output
    }
    queue := []*TreeNode{}
    queue = append(queue, root)
    for ; len(queue) > 0; {
        size := len(queue)
        row := []int{}
        for i := 0; i < size; i++ {
            cur := queue[i]
            row = append(row, cur.Val)
            if cur.Left != nil {
                queue = append(queue, cur.Left)
            }
            if cur.Right != nil {
                queue = append(queue, cur.Right)
            }
        }
        output = append(output, row)
        queue = queue[size:]
    }
    return output
}