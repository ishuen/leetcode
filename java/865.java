// 865. Smallest Subtree with all the Deepest Nodes
//
// Given the root of a binary tree, the depth of each node is the shortest distance to the root.
//
// Return the smallest subtree such that it contains all the deepest nodes in the original tree.
//
// A node is called the deepest if it has the largest depth possible among any node in the entire tree.
//
// The subtree of a node is a tree consisting of that node, plus the set of all descendants of that node.
//
//
//
// Example 1:
//
//
// Input: root = [3,5,1,6,2,0,8,null,null,7,4]
// Output: [2,7,4]
// Explanation: We return the node with value 2, colored in yellow in the diagram.
// The nodes coloured in blue are the deepest nodes of the tree.
// Notice that nodes 5, 3 and 2 contain the deepest nodes in the tree but node 2 is the smallest subtree among them, so we return it.
// Example 2:
//
// Input: root = [1]
// Output: [1]
// Explanation: The root is the deepest node in the tree.
// Example 3:
//
// Input: root = [0,1,3,null,2]
// Output: [2]
// Explanation: The deepest node in the tree is 2, the valid subtrees are the subtrees of nodes 2, 1 and 0 but the subtree of node 2 is the smallest.
//
//
// Constraints:
//
// The number of nodes in the tree will be in the range [1, 500].
// 0 <= Node.val <= 500
// The values of the nodes in the tree are unique.
//
// Runtime 2 ms Beats 7.94%
// Memory 41.2 MB Beats 33.97%
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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Set<TreeNode> set = new HashSet<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        parentMap.put(root, null);
        while(!queue.isEmpty()) {
            int size = queue.size();
            set.clear();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                set.add(cur);
                if (cur.left != null) {
                    queue.add(cur.left);
                    parentMap.put(cur.left, cur);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    parentMap.put(cur.right, cur);
                }
            }
        }
        while (set.size() > 1) {
            Iterator<TreeNode> it = set.iterator();
            Set<TreeNode> prevLayer = new HashSet<>();
            while(it.hasNext()) {
                TreeNode child = it.next();
                TreeNode parent = parentMap.get(child);
                if (parent != null) prevLayer.add(parent);
            }
            set = prevLayer;
        }
        return set.size() > 0 ? set.iterator().next(): root;
    }
}

// Runtime 0 ms Beats 100%
// Memory 40.9 MB Beats 61.59%
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == rightHeight) return root;
        else if (leftHeight > rightHeight) return subtreeWithAllDeepest(root.left);
        else return subtreeWithAllDeepest(root.right);
    }
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}

