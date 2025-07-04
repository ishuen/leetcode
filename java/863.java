// 863. All Nodes Distance K in Binary Tree
//
// Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
//
// You can return the answer in any order.
//
//
//
// Example 1:
//
//
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
// Output: [7,4,1]
// Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
// Example 2:
//
// Input: root = [1], target = 1, k = 3
// Output: []
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 500].
// 0 <= Node.val <= 500
// All the values Node.val are unique.
// target is the value of one of the nodes in the tree.
// 0 <= k <= 1000
//
// Runtime 10 ms Beats 98.76%
// Memory 41.8 MB Beats 98.25%
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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (cur == target) {
                checkParent(cur, parentMap, k, ans);
                checkChild(cur, k, ans);
                break;
            }
            if (cur.left != null) {
                parentMap.put(cur.left, cur);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                parentMap.put(cur.right, cur);
                queue.add(cur.right);
            }
        }
        return ans;
    }

    private void checkParent(TreeNode last, Map<TreeNode, TreeNode> map, int k, List<Integer> ans) {
        int count = 0;
        TreeNode cur = last;
        while(map.get(cur) != null && count < k) {
            TreeNode parent = map.get(cur);
            count++;
            if (count == k) {
                ans.add(parent.val);
                break;
            }
            TreeNode another = parent.left == cur ? parent.right : parent.left;
            checkChild(another, k - count - 1, ans);
            cur = parent;
        }
    }

    private void checkChild(TreeNode start, int k, List<Integer> ans) {
        if (start == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty() && k >= 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if (k == 0) ans.add(cur.val);
                else {
                    if (cur.left != null) {
                        queue.add(cur.left);
                    }
                    if (cur.right != null) {
                        queue.add(cur.right);
                    }
                }
            }
            k--;
        }
    }
}
