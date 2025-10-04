// 95. Unique Binary Search Trees II

// Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.

 

// Example 1:


// Input: n = 3
// Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// Example 2:

// Input: n = 1
// Output: [[1]]
 

// Constraints:

// 1 <= n <= 8

// Runtime 0 ms Beats 100.00%
// Memory 6.23 MB Beats 53.85%
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func generateTrees(n int) []*TreeNode {
    var generate func(start int, end int) []*TreeNode
    generate = func(start int, end int) []*TreeNode {
        if start > end {
            return []*TreeNode{nil}
        }
        output := []*TreeNode{}
        for i := start; i <= end; i++ {
            left := generate(start, i - 1)
            right := generate(i + 1, end)
            for _, l := range left {
                for _, r := range right {
                    root := &TreeNode {
                        Val: i,
                        Left: l,
                        Right: r,
                    }
                    output = append(output, root)
                }
            }
        }
        return output
    }
    return generate(1, n)
}