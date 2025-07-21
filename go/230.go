// 230. Kth Smallest Element in a BST

// Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 

// Example 1:


// Input: root = [3,1,4,null,2], k = 1
// Output: 1
// Example 2:


// Input: root = [5,3,6,2,4,null,null,1], k = 3
// Output: 3
 

// Constraints:

// The number of nodes in the tree is n.
// 1 <= k <= n <= 104
// 0 <= Node.val <= 104
 

// Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?

// Runtime 0 ms Beats 100.00%
// Memory 7.90 MB Beats 88.42%
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func kthSmallest(root *TreeNode, k int) int {
    counter := 0
    kValue := 0
    var dfs func(root *TreeNode)
    dfs = func(root *TreeNode) {
        if root == nil || counter > k {
            return
        }
        dfs(root.Left)
        counter++
        if (counter == k) {
            kValue = root.Val
            return
        }
        dfs(root.Right)
    }
    dfs(root)
    return kValue
}