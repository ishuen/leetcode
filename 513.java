// 513. Find Bottom Left Tree Value
// Given the root of a binary tree, return the leftmost value in the last row of the tree.
//
// Example 1:
//
//
// Input: root = [2,1,3]
// Output: 1
// Example 2:
//
//
// Input: root = [1,2,3,4,null,5,6,null,null,7]
// Output: 7
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 104].
// -231 <= Node.val <= 231 - 1
//
// Runtime: 1 ms, faster than 65.70% of Java online submissions for Find Bottom Left Tree Value.
// Memory Usage: 38.8 MB, less than 37.83% of Java online submissions for Find Bottom Left Tree Value.
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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = queue.size();
        int degree = 0;
        int left = 0;
        int curDegree = 0;
        while(!queue.isEmpty()) {
            curDegree++;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if (curDegree > degree) {
                    degree = curDegree;
                    left = cur.val;
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            size = queue.size();
        }
        return left;
    }
}