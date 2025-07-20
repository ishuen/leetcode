// 199. Binary Tree Right Side View

// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

// Example 1:

// Input: root = [1,2,3,null,5,null,4]

// Output: [1,3,4]

// Explanation:



// Example 2:

// Input: root = [1,2,3,4,null,null,null,5]

// Output: [1,3,4,5]

// Explanation:



// Example 3:

// Input: root = [1,null,3]

// Output: [1,3]

// Example 4:

// Input: root = []

// Output: []

 

// Constraints:

// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100

// Runtime 0 ms Beats 100.00%
// Memory 4.48 MB Beats 8.19%
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func rightSideView(root *TreeNode) []int {
    output := []int{}
    if root == nil {
        return output
    }
    queue := []*TreeNode{}
    queue = append(queue, root)
    for ; len(queue) > 0; {
        size := len(queue)
        output = append(output, queue[size - 1].Val)
        for i := 0; i < size; i++ {
            cur := queue[i]
            if cur.Left != nil {
                queue = append(queue, cur.Left)
            }
            if cur.Right != nil {
                queue = append(queue, cur.Right)
            }
        }
        queue = queue[size:]
    }
    return output
}