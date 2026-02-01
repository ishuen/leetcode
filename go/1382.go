// 1382. Balance a Binary Search Tree

// Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

// A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

 

// Example 1:


// Input: root = [1,null,2,null,3,null,4,null,null]
// Output: [2,1,3,null,null,null,4]
// Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
// Example 2:


// Input: root = [2,1,3]
// Output: [2,1,3]
 

// Constraints:

// The number of nodes in the tree is in the range [1, 104].
// 1 <= Node.val <= 105

// Runtime 1 ms Beats 92.00%
// Memory 9.46 MB Beats 44.00%
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func balanceBST(root *TreeNode) *TreeNode {
    list := []int{}
    var getList func(node *TreeNode)
    getList = func(node *TreeNode){
        if node == nil {
            return
        }
        getList(node.Left)
        list = append(list, node.Val)
        getList(node.Right)
    }
    getList(root)
    var createTree func(start, end int) *TreeNode
    createTree = func(start, end int) *TreeNode {
        if start > end {
            return nil
        }
        mid := (start + end)/ 2
        left := createTree(start, mid - 1)
        right := createTree(mid + 1, end)
        root := &TreeNode{
            Val: list[mid],
            Left: left,
            Right: right,
        }
        return root
    }
    return createTree(0, len(list) - 1)
}
