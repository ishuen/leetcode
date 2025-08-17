// 108. Convert Sorted Array to Binary Search Tree

// Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

 

// Example 1:


// Input: nums = [-10,-3,0,5,9]
// Output: [0,-3,9,-10,null,5]
// Explanation: [0,-10,5,null,-3,null,9] is also accepted:

// Example 2:


// Input: nums = [1,3]
// Output: [3,1]
// Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 

// Constraints:

// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums is sorted in a strictly increasing order.
// Runtime 0 ms Beats 100.00%
// Memory 5.27 MB Beats 74.48%
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func sortedArrayToBST(nums []int) *TreeNode {
    var center int
    center = len(nums) / 2
    node := &TreeNode{Val: nums[center]}
    if center > 0 {
        node.Left = sortedArrayToBST(nums[:center])
    }
    if center < len(nums) - 1 {
        node.Right = sortedArrayToBST(nums[center + 1:])
    }
    return node
}