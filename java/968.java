// 968. Binary Tree Cameras
// You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.
//
// Return the minimum number of cameras needed to monitor all nodes of the tree.
//
//
//
// Example 1:
//
//
// Input: root = [0,0,null,0,0]
// Output: 1
// Explanation: One camera is enough to monitor all nodes if placed as shown.
// Example 2:
//
//
// Input: root = [0,0,null,0,null,0,null,null,0]
// Output: 2
// Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 1000].
// Node.val == 0
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Cameras.
// Memory Usage: 38.7 MB, less than 53.34% of Java online submissions for Binary Tree Cameras.
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
    int count = 0;
    public int minCameraCover(TreeNode root) {
        int cur = setCamera(root);
        return cur == 0 ? count + 1 : count;
    }
    public int setCamera(TreeNode root) {
        if (root == null) return -1;
        int left = setCamera(root.left);
        int right = setCamera(root.right);
        if (left == 0 || right == 0) {
            count++;
            return 1;
        }
        return left == 1 || right == 1 ? -1: 0;
    }
}

// 0: leaf
// 1: with camera
// 2: parent
//     if below == 0 -> cur = 1
//     else if below  == 1 -> cur = -1
//     else if below  == -1 -> cur = 0