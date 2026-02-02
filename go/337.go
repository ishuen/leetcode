// 337. House Robber III

// The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

// Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.

// Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.

 

// Example 1:


// Input: root = [3,2,3,null,3,null,1]
// Output: 7
// Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
// Example 2:


// Input: root = [3,4,5,1,3,null,1]
// Output: 9
// Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 

// Constraints:

// The number of nodes in the tree is in the range [1, 104].
// 0 <= Node.val <= 104

// Runtime 3 ms Beats 17.89%
// Memory 7.89 MB Beats 15.79%
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var memory = make(map[*TreeNode]int)
func rob(root *TreeNode) int {
    if root == nil {
        return 0
    }
    v, ok := memory[root]
    if ok {
        return v
    }
    leftMax, leftChildMax := 0, 0
    rightMax, rightChildMax := 0, 0
    if root.Left != nil {
        leftMax = rob(root.Left)
        leftChildMax = rob(root.Left.Left) + rob(root.Left.Right)
    }
    if root.Right != nil {
        rightMax = rob(root.Right)
        rightChildMax = rob(root.Right.Left) + rob(root.Right.Right)
    }
    result := max(root.Val + leftChildMax + rightChildMax, leftMax + rightMax)
    memory[root] = result
    return result
}


// Runtime 0 ms Beats 100.00%
// Memory 7.03 MB Beats 69.47%
func robber(root *TreeNode) (int, int) {
    if root == nil {
        return 0, 0
    }
    left1, left2 := robber(root.Left)
    right1, right2 := robber(root.Right)
    return root.Val + left2 + right2, max(left1, left2) + max(right1, right2)
}
func rob(root *TreeNode) int {
    layer1, layer2 := robber(root)
    return max(layer1, layer2)
}