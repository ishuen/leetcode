// 116. Populating Next Right Pointers in Each Node
// You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
//
// struct Node {
//   int val;
//   Node *left;
//   Node *right;
//   Node *next;
// }
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//
// Initially, all next pointers are set to NULL.
//
//
//
// Example 1:
//
//
// Input: root = [1,2,3,4,5,6,7]
// Output: [1,#,2,3,#,4,5,6,7,#]
// Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
// Example 2:
//
// Input: root = []
// Output: []
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [0, 212 - 1].
// -1000 <= Node.val <= 1000
//
//
// Follow-up:
//
// You may only use constant extra space.
// The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
//
// Runtime: 5 ms, faster than 6.58% of Java online submissions for Populating Next Right Pointers in Each Node.
// Memory Usage: 45.1 MB, less than 5.75% of Java online submissions for Populating Next Right Pointers in Each Node.
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();
                if (queue.peek() != null && i != size - 1) {
                    cur.next = queue.peek();
                }
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        return root;
    }
}

// queue[1]
// size of queue = # nodes in the same layer
// if peek != null -> node.next = peek
// dequeue(1) -> enqueue childrens