// 113. Path Sum II

// Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

// A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

 

// Example 1:


// Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// Output: [[5,4,11,2],[5,8,4,5]]
// Explanation: There are two paths whose sum equals targetSum:
// 5 + 4 + 11 + 2 = 22
// 5 + 8 + 4 + 5 = 22
// Example 2:


// Input: root = [1,2,3], targetSum = 5
// Output: []
// Example 3:

// Input: root = [1,2], targetSum = 0
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 5000].
// -1000 <= Node.val <= 1000
// -1000 <= targetSum <= 1000

// Runtime 0 ms Beats 100.00%
// Memory 6.50 MB Beats 55.77%
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func pathSum(root *TreeNode, targetSum int) [][]int {
    outputList := [][]int{}
    if root == nil {
        return outputList
    }
    var traverse func(curSum int, curNode *TreeNode, curList []int)
    traverse = func(curSum int, curNode *TreeNode, curList []int) {
        curList = append(curList, curNode.Val)
        curSum = curSum + curNode.Val
        if curNode.Left != nil || curNode.Right != nil {
            if curNode.Left != nil {
                traverse(curSum, curNode.Left, curList)
            }
            if curNode.Right != nil {
                traverse(curSum, curNode.Right, curList)
            }
        } else {
            if curSum == targetSum {
                list := make([]int, len(curList))
                copy(list, curList)
                outputList = append(outputList, list)
            }
        }
    }
    traverse(0, root, []int{})
    return outputList
}