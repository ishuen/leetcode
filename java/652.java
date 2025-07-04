// 652. Find Duplicate Subtrees
// Given the root of a binary tree, return all duplicate subtrees.
//
// For each kind of duplicate subtrees, you only need to return the root node of any one of them.
//
// Two trees are duplicate if they have the same structure with the same node values.
//
//
//
// Example 1:
//
//
// Input: root = [1,2,3,4,null,2,4,null,null,4]
// Output: [[2,4],[4]]
// Example 2:
//
//
// Input: root = [2,1,1]
// Output: [[1]]
// Example 3:
//
//
// Input: root = [2,2,2,3,null,3,null]
// Output: [[2,3],[3]]
//
//
// Constraints:
//
// The number of the nodes in the tree will be in the range [1, 10^4]
// -200 <= Node.val <= 200
//
// Runtime: 30 ms, faster than 23.40% of Java online submissions for Find Duplicate Subtrees.
// Memory Usage: 53 MB, less than 19.41% of Java online submissions for Find Duplicate Subtrees.
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
    private Map<String, Integer> countMap;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        countMap = new HashMap<>();
        List<TreeNode> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }
    private String traverse(TreeNode root, List<TreeNode> list) {
        if (root == null) return ".";
        String key = root.val + ":" + traverse(root.left, list) + "-" + traverse(root.right, list);
        int count = countMap.getOrDefault(key, 0);
        if (count == 1) {
            list.add(root);
            countMap.put(key, 2);
        } else if (count == 0) {
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }
        return key;
    }
}