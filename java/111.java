// 111. Minimum Depth of Binary Tree
// Given a binary tree, find its minimum depth.
//
// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//
// Note: A leaf is a node with no children.
//
//
//
// Example 1:
//
//
// Input: root = [3,9,20,null,null,15,7]
// Output: 2
// Example 2:
//
// Input: root = [2,null,3,null,4,null,5,null,6]
// Output: 5
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [0, 105].
// -1000 <= Node.val <= 1000
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary Tree.
// Memory Usage: 59.1 MB, less than 87.74% of Java online submissions for Minimum Depth of Binary Tree.
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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    TreeNode left = node.left;
                    if (left.left == null && left.right == null) return depth + 1;
                    queue.add(left);
                }
                if (node.right != null) {
                    TreeNode right = node.right;
                    if (right.left == null && right.right == null) return depth + 1;
                    queue.add(right);
                }
            }
        }
        return depth;
    }
}


// Runtime: 1 ms, faster than 88.69% of Java online submissions for Minimum Depth of Binary Tree.
// Memory Usage: 92.6 MB, less than 26.75% of Java online submissions for Minimum Depth of Binary Tree.
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return depth;
    }
}