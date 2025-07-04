// 1161. Maximum Level Sum of a Binary Tree
//
// Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
//
// Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
//
//
//
// Example 1:
//
//
// Input: root = [1,7,0,7,-8,null,null]
// Output: 2
// Explanation:
// Level 1 sum = 1.
// Level 2 sum = 7 + 0 = 7.
// Level 3 sum = 7 + -8 = -1.
// So we return the level with the maximum sum which is level 2.
// Example 2:
//
// Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
// Output: 2
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 104].
// -105 <= Node.val <= 105
//
// Runtime 9ms Beats 31.94%of users with Java
// Memory 46.47MB Beats 21.64%of users with Java
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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> elementsInLevel = new LinkedList<>();
        int level = 0;
        int max = Integer.MIN_VALUE;
        int curLevel = 0;
        elementsInLevel.add(root);
        while (!elementsInLevel.isEmpty()) {
            int size = elementsInLevel.size();
            int sum = 0;
            curLevel++;
            for (int i = 0; i < size; i++) {
                TreeNode cur = elementsInLevel.remove();
                sum = sum + cur.val;
                if (cur.left != null) {
                    elementsInLevel.add(cur.left);
                }
                if (cur.right != null) {
                    elementsInLevel.add(cur.right);
                }
            }
            if (sum > max) {
                max = sum;
                level = curLevel;
            }
        }
        return level;
    }
}