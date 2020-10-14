// 637. Average of Levels in Binary Tree
//   Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
//   Example 1:
//
//   Input:
//       3
//      / \
//     9  20
//       /  \
//      15   7
//   Output: [3, 14.5, 11]
//   Explanation:
//   The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
//   Note:
//
//   The range of node's value is in the range of 32-bit signed integer.
//
// Runtime: 2 ms, faster than 83.97% of Java online submissions for Average of Levels in Binary Tree.
// Memory Usage: 40.9 MB, less than 6.48% of Java online submissions for Average of Levels in Binary Tree.
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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Double sum = 0.0;
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                sum = sum + Double.valueOf(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }  
            }
            result.add(sum / n);
        }
        return result;
    }
}