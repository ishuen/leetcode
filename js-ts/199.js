// 199. Binary Tree Right Side View
//
// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
//
//
// Example 1:
//
//
// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]
// Example 2:
//
// Input: root = [1,null,3]
// Output: [1,3]
// Example 3:
//
// Input: root = []
// Output: []
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
//
// Runtime 62 ms Beats 24.04% of users with JavaScript
// Memory 43.91 MB Beats 26.36% of users with JavaScript
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var rightSideView = function(root) {
    if (root == null) return [];
    let list = [];
    let queue = [root];
    while (queue.length > 0) {
        let size = queue.length;
        list.push(queue[0].val);
        for (let i = 0; i < size; i++) {
            let cur = queue.shift();
            if (cur.right != null) {
                queue.push(cur.right);
            }
            if (cur.left != null) {
                queue.push(cur.left)
            }
        }   
    }
    return list
};