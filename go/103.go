// 103. Binary Tree Zigzag Level Order Traversal

// Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[20,9],[15,7]]
// Example 2:

// Input: root = [1]
// Output: [[1]]
// Example 3:

// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 2000].
// -100 <= Node.val <= 100

// Runtime 0 ms Beats 100.00%
// Memory 4.57 MB Beats 67.17%

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func zigzagLevelOrder(root *TreeNode) [][]int {
    output := [][]int{}
    if root == nil {
        return output
    }
    queue := []*TreeNode{}
    queue = append(queue, root)
    isEven := true
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
        if isEven == false {
            slices.Reverse(row)
        }
        isEven = !isEven
        output = append(output, row)
        queue = queue[size:]
    }
    return output
}
