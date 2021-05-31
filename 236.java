// 236. Lowest Common Ancestor of a Binary Tree
// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
// Example 1:
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// Output: 3
// Explanation: The LCA of nodes 5 and 1 is 3.
// Example 2:
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
// Output: 5
// Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
// Example 3:
// Input: root = [1,2], p = 1, q = 2
// Output: 1
// Constraints:
// The number of nodes in the tree is in the range [2, 105].
// -109 <= Node.val <= 109
// All Node.val are unique.
// p != q
// p and q will exist in the tree.
//
// Runtime: 10 ms, faster than 12.99% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
// Memory Usage: 39.3 MB, less than 99.36% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> reverseMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean foundP = false;
        boolean foundQ = false;
        queue.add(root);
        reverseMap.put(root, null);
        while(!foundP || !foundQ) {
            TreeNode cur = queue.remove();
            if (cur == p) foundP = true;
            else if (cur == q) foundQ = true;
            if (cur.left != null) {
                queue.add(cur.left);
                reverseMap.put(cur.left, cur);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                reverseMap.put(cur.right, cur);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        TreeNode temp = p;
        while(temp != null) {
            set.add(temp);
            temp = reverseMap.get(temp);
        }
        temp = q;
        while(!set.contains(temp)) {
            temp = reverseMap.get(temp);
        }
        return temp;
    }
}

// Runtime: 4 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
// Memory Usage: 41.1 MB, less than 50.50% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (root == p || root == q) return root;
        TreeNode left  = lowestCommonAncestor(root.left, p, q);
        TreeNode right  = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}