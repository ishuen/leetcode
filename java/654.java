// 654. Maximum Binary Tree
// You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:
//
// Create a root node whose value is the maximum value in nums.
// Recursively build the left subtree on the subarray prefix to the left of the maximum value.
// Recursively build the right subtree on the subarray suffix to the right of the maximum value.
// Return the maximum binary tree built from nums.
//
//
//
// Example 1:
//
//
// Input: nums = [3,2,1,6,0,5]
// Output: [6,3,5,null,2,0,null,null,1]
// Explanation: The recursive calls are as follow:
// - The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right suffix is [0,5].
//     - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix is [2,1].
//         - Empty array, so no child.
//         - The largest value in [2,1] is 2. Left prefix is [] and right suffix is [1].
//             - Empty array, so no child.
//             - Only one element, so child is a node with value 1.
//     - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is [].
//         - Only one element, so child is a node with value 0.
//         - Empty array, so no child.
// Example 2:
//
//
// Input: nums = [3,2,1]
// Output: [3,null,2,null,1]
//
//
// Constraints:
//
// 1 <= nums.length <= 1000
// 0 <= nums[i] <= 1000
// All integers in nums are unique.
//
// Runtime: 3 ms, faster than 34.51% of Java online submissions for Maximum Binary Tree.
// Memory Usage: 51.6 MB, less than 7.45% of Java online submissions for Maximum Binary Tree.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return addNode(0, nums.length - 1, nums);
    }
    
    private TreeNode addNode(int start, int end, int[] nums) {
        if (start == end) return new TreeNode(nums[start]);
        int maxIndex = findMax(start, end, nums);
        TreeNode root = new TreeNode(nums[maxIndex]);
        if (maxIndex > start) root.left = addNode(start, maxIndex - 1, nums);
        if (maxIndex < end) root.right = addNode(maxIndex + 1, end, nums);
        return root;
    }
    
    private int findMax(int start, int end, int[] nums) {
        int max = nums[start];
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}