// 530. Minimum Absolute Difference in BST

// Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

 

// Example 1:


// Input: root = [4,2,6,1,3]
// Output: 1
// Example 2:


// Input: root = [1,0,48,null,null,12,49]
// Output: 1
 

// Constraints:

// The number of nodes in the tree is in the range [2, 104].
// 0 <= Node.val <= 105


// Runtime 0 ms Beats 100.00%
// Memory 8.47 MB Beats 73.84%
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func getMinimumDifference(root *TreeNode) int {
    minDiff := 100000
    var traverse func(root *TreeNode) (int, int)
    traverse = func(root *TreeNode) (int, int) {
        if root == nil {
            return -1, -1
        }
        leftMin, leftMax, rightMin, rightMax := -1, -1, -1, -1
        if root.Left != nil {
            leftMin, leftMax = traverse(root.Left)

        }
        if root.Right != nil {
            rightMin, rightMax = traverse(root.Right)
        }
        if leftMax != -1 {
            minDiff = min(minDiff, root.Val - leftMax)
        }
        if rightMin != -1 {
            minDiff = min(minDiff, rightMin - root.Val)
        }
        if leftMin == -1 && leftMax == -1 {
            leftMin = root.Val
        }
        if rightMin == -1 && rightMax == -1 {
            rightMax = root.Val
        }
        return leftMin, rightMax
    }
    traverse(root)
    return minDiff
}


// Runtime 0 ms Beats 100.00%
// Memory 8.84 MB Beats 22.94%
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func getMinimumDifference(root *TreeNode) int {
    minDiff := 100000
    var prev *TreeNode
    var traverse func(root *TreeNode)
    traverse = func(root *TreeNode) {
        if root == nil {
            return
        }
        if root.Left != nil {
            traverse(root.Left)
        }
        if prev != nil {
            minDiff = min(minDiff, root.Val - prev.Val)
        }
        prev = root
        if root.Right != nil {
            traverse(root.Right)
        }
    }
    traverse(root)
    return minDiff
}
