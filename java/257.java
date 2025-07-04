// 257. Binary Tree Paths
// Given the root of a binary tree, return all root-to-leaf paths in any order.
//
// A leaf is a node with no children.
//
//
//
// Example 1:
//
//
// Input: root = [1,2,3,null,5]
// Output: ["1->2->5","1->3"]
// Example 2:
//
// Input: root = [1]
// Output: ["1"]
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 100].
// -100 <= Node.val <= 100
//
// Runtime: 8 ms, faster than 59.43% of Java online submissions for Binary Tree Paths.
// Memory Usage: 39.7 MB, less than 17.03% of Java online submissions for Binary Tree Paths.
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        path(root, "", paths);
        return paths;
    }
    
    private void path(TreeNode root, String cur, List<String> paths) {
        if (root.left == null && root.right == null) {
            paths.add(cur + root.val);
        } else {
            if (root.left != null) path(root.left, cur + root.val + "->", paths);
            if (root.right != null) path(root.right, cur + root.val + "->", paths);
        }
    }
}