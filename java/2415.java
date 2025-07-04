// 2415. Reverse Odd Levels of Binary Tree
//
// Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.
//
// For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
// Return the root of the reversed tree.
//
// A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.
//
// The level of a node is the number of edges along the path between it and the root node.
//
//
//
// Example 1:
//
//
// Input: root = [2,3,5,8,13,21,34]
// Output: [2,5,3,8,13,21,34]
// Explanation:
// The tree has only one odd level.
// The nodes at level 1 are 3, 5 respectively, which are reversed and become 5, 3.
// Example 2:
//
//
// Input: root = [7,13,11]
// Output: [7,11,13]
// Explanation:
// The nodes at level 1 are 13, 11, which are reversed and become 11, 13.
// Example 3:
//
// Input: root = [0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
// Output: [0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
// Explanation:
// The odd levels have non-zero values.
// The nodes at level 1 were 1, 2, and are 2, 1 after the reversal.
// The nodes at level 3 were 1, 1, 1, 1, 2, 2, 2, 2, and are 2, 2, 2, 2, 1, 1, 1, 1 after the reversal.
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 214].
// 0 <= Node.val <= 105
// root is a perfect binary tree.


// Runtime 17 ms Beats 7.09%
// Memory 49.22 MB Beats 23.31%
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
    public TreeNode reverseOddLevels(TreeNode root) {
        int counter = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> secondStack = new Stack<>();
        Queue<TreeNode> thirdQueue = new LinkedList<>();
        Queue<TreeNode> fourthQueue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    TreeNode l = node.left;
                    TreeNode r = node.right;
                    secondStack.push(l);
                    secondStack.push(r);
                    if (l.left != null) {
                        thirdQueue.add(l.left);
                        thirdQueue.add(l.right);
                        thirdQueue.add(r.left);
                        thirdQueue.add(r.right);
                    }
                }
                fourthQueue.add(node);
            }
            for (int i = 0; i < size; i++) {
                if (secondStack.isEmpty()) break;
                TreeNode node = fourthQueue.remove();
                TreeNode l = secondStack.pop();
                TreeNode r = secondStack.pop();
                if (!thirdQueue.isEmpty()) {
                	l.left = thirdQueue.remove();
                	l.right = thirdQueue.remove();
                	r.left = thirdQueue.remove();
                	r.right = thirdQueue.remove();
                	queue.add(l.left);
                	queue.add(l.right);
                	queue.add(r.left);
                	queue.add(r.right);
                }
                node.left = l;
                node.right = r;
            }
            counter = counter + 2;
        }
        return root;
    }
}


// Runtime 0 ms Beats 100.00%
// Memory 48.18 MB Beats 83.28%
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        bfs(root.left, root.right, 1);
        return root;
    }

    private void bfs(TreeNode left, TreeNode right, int level) {
        if (left == null || right == null) return;
        if (level % 2 == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        bfs(left.left, right.right, level + 1);
        bfs(left.right, right.left, level + 1);
    }
}
