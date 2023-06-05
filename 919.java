// 919. Complete Binary Tree Inserter
//
// A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.
//
// Design an algorithm to insert a new node to a complete binary tree keeping it complete after the insertion.
//
// Implement the CBTInserter class:
//
// CBTInserter(TreeNode root) Initializes the data structure with the root of the complete binary tree.
// int insert(int v) Inserts a TreeNode into the tree with value Node.val == val so that the tree remains complete, and returns the value of the parent of the inserted TreeNode.
// TreeNode get_root() Returns the root node of the tree.
//
//
// Example 1:
//
//
// Input
// ["CBTInserter", "insert", "insert", "get_root"]
// [[[1, 2]], [3], [4], []]
// Output
// [null, 1, 2, [1, 2, 3, 4]]
//
// Explanation
// CBTInserter cBTInserter = new CBTInserter([1, 2]);
// cBTInserter.insert(3);  // return 1
// cBTInserter.insert(4);  // return 2
// cBTInserter.get_root(); // return [1, 2, 3, 4]
//
//
// Constraints:
//
// The number of nodes in the tree will be in the range [1, 1000].
// 0 <= Node.val <= 5000
// root is a complete binary tree.
// 0 <= val <= 5000
// At most 104 calls will be made to insert and get_root.
//
// Runtime 14 ms Beats 99.45%
// Memory 43.9 MB Beats 25.27%
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
class CBTInserter {

    private TreeNode root;
    private Queue<TreeNode> availableNodes;
    public CBTInserter(TreeNode root) {
        this.root = root;
        availableNodes = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (cur.left == null || cur.right == null) {
                availableNodes.add(cur);
            }
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }
    
    public int insert(int val) {
        TreeNode newNode = new TreeNode(val);
        TreeNode parent = availableNodes.peek();
        if (parent.left == null) {
            parent.left = newNode;
        } else {
			// Edge case: if the parent only has right node when init,
			// the insertion will overwrite the initial right node with new value.
            parent.right = newNode;
            availableNodes.remove();
        }
        availableNodes.add(newNode);
        return parent.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
