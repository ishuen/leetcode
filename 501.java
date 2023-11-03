// 501. Find Mode in Binary Search Tree
//
// Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
//
// If the tree has more than one mode, return them in any order.
//
// Assume a BST is defined as follows:
//
// The left subtree of a node contains only nodes with keys less than or equal to the node's key.
// The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
// Both the left and right subtrees must also be binary search trees.
//
//
// Example 1:
//
//
// Input: root = [1,null,2,2]
// Output: [2]
// Example 2:
//
// Input: root = [0]
// Output: [0]
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 104].
// -105 <= Node.val <= 105
//
//
// Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
//
// Runtime 11 ms Beats 9.77%
// Memory 44.9 MB Beats 20.54%
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
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int key: map.keySet()) {
            int count = map.get(key);
            if (count > max) {
                max = count;
                list.clear();
                list.add(key);
            } else if (count == max) {
                list.add(key);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}

// Runtime 1 ms Beats 74.52%
// Memory 44 MB Beats 70.9%
class Solution {
    private int max = Integer.MIN_VALUE;
    private int prev = Integer.MIN_VALUE;
    private int count = 1;
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        findMode(root, list);
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    private void findMode(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            findMode(root.left, list);
        }
        if (root.val == prev) {
            count++;
        } else {
            prev = root.val;
            count = 1;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        if (root.right != null) {
            findMode(root.right, list);
        }
    }
}


// Runtime 13ms Beats 7.97%of users with Java
// Memory 44.76MB Beats 25.72%of users with Java
class Solution {
    public int[] findMode(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Map<Integer, Integer> map = new HashMap<>();
        int curValue = Integer.MIN_VALUE;
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            int count = map.getOrDefault(cur.val, 0);
            count++;
            map.put(cur.val, count);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        List<Integer> ans = new ArrayList<>();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                ans = new ArrayList<>();
                ans.add(entry.getKey());
            } else if (entry.getValue() == max){
                ans.add(entry.getKey());
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}