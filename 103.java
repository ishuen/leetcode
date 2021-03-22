// 103. Binary Tree Zigzag Level Order Traversal
// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its zigzag level order traversal as:
//
// [
//   [3],
//   [20,9],
//   [15,7]
// ]
//
// Runtime: 1 ms, faster than 73.92% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
// Memory Usage: 39.4 MB, less than 22.59% of Java online submissions for Binary Tree Zigzag Level Order Traversal.

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur;
        queue.add(root);
        int counter = 0;
        while(!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                cur = queue.remove();
                tempList.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            counter++;
            if (counter % 2 == 0) Collections.reverse(tempList);
            ans.add(tempList);
        }
        return ans;
    }
}