// 1302. Deepest Leaves Sum
//
// Given the root of a binary tree, return the sum of values of its deepest leaves.
//
//
// Example 1:
//
//
// Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
// Output: 15
// Example 2:
//
// Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
// Output: 19
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 104].
// 1 <= Node.val <= 100
//
// Runtime 7ms Beats 42.22%of users with Java
// Memory 45.20MB Beats 69.02%of users with Java
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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                sum = sum + cur.val;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return sum;
    }
}

// Runtime 1ms Beats 100.00%of users with Java
// Memory 45.21MB Beats 63.18%of users with Java
class Solution {
    private int maxLevel = Integer.MIN_VALUE;
    private int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
       dfs(root, 0);
       return sum;
    }

    private void dfs(TreeNode root, int curLevel) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (curLevel > maxLevel) {
                maxLevel = curLevel;
                sum = root.val;
            } else if (curLevel == maxLevel) {
                sum = sum + root.val;
            }
        }
        dfs(root.left, curLevel + 1);
        dfs(root.right, curLevel + 1);
    }
}