// 1110. Delete Nodes And Return Forest
// Given the root of a binary tree, each node in the tree has a distinct value.
//
// After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
//
// Return the roots of the trees in the remaining forest. You may return the result in any order.
//
//
//
// Example 1:
//
//
// Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
// Output: [[1,2,null,4],[6],[7]]
// Example 2:
//
// Input: root = [1,2,4,null,3], to_delete = [3]
// Output: [[1,2,4]]
//
//
// Constraints:
//
// The number of nodes in the given tree is at most 1000.
// Each node has a distinct value between 1 and 1000.
// to_delete.length <= 1000
// to_delete contains distinct values between 1 and 1000.
//
// Runtime 1ms Beats 98.78%of users with Java
// Memory 43.72MB Beats 72.14%of users with Java
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int val: to_delete) {
            set.add(val);
        }
        traverse(root, set, list, null);
        return list;
    }

    private void traverse(TreeNode cur, Set<Integer> set, List<TreeNode> list, TreeNode parent) {
        if (cur == null) {
            return;
        }
        traverse(cur.left, set, list, cur);
        traverse(cur.right, set, list, cur);
        if (set.contains(cur.val)) {
            if (cur.left != null && !set.contains(cur.left.val)) {
                list.add(cur.left);
            }
            if (cur.right != null && !set.contains(cur.right.val)) {
                list.add(cur.right);
            }
            if (parent != null && cur == parent.left) {
                parent.left = null;
            } else if (parent != null && cur == parent.right) {
                parent.right = null;
            }
        } else {
            if (parent == null) {
                list.add(cur);
            }
        }
    }
}