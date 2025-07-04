// 449. Serialize and Deserialize BST
// Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//
// Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.
//
// The encoded string should be as compact as possible.
//
//
//
// Example 1:
//
// Input: root = [2,1,3]
// Output: [2,1,3]
// Example 2:
//
// Input: root = []
// Output: []
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [0, 104].
// 0 <= Node.val <= 104
// The input tree is guaranteed to be a binary search tree.
//
// Runtime 15 ms Beats 32.20%
// Memory 43.5 MB Beats 60.5%
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
		if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        sb.append(root.val);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if (temp.left != null) {
                queue.add(temp.left);
                sb.append("," + temp.left.val);
            } else {
                sb.append(",null");
            }
            if (temp.right != null) {
                queue.add(temp.right);
                sb.append("," + temp.right.val);
            } else {
                sb.append(",null");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] dataArr = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty() && index < dataArr.length) {
            TreeNode temp = queue.remove();
            if (index < dataArr.length) {
                if (!dataArr[index].equals("null")) {
                    TreeNode left = new TreeNode(Integer.parseInt(dataArr[index]));
                    temp.left = left;
                    queue.add(left);
                }
                index++;
            }
            if (index < dataArr.length) {
                if (!dataArr[index].equals("null")) {
                    TreeNode right = new TreeNode(Integer.parseInt(dataArr[index]));
                    temp.right = right;
                    queue.add(right);
                }
                index++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
