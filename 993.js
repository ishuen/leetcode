// 993. Cousins in Binary Tree
// In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
//
// Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
//
// We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
//
// Return true if and only if the nodes corresponding to the values x and y are cousins.
// Example 1:
// Input: root = [1,2,3,4], x = 4, y = 3
// Output: false
// Example 2:
// Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
// Output: true
// Example 3:
// Input: root = [1,2,3,null,4], x = 2, y = 3
// Output: false
//
// Constraints:
// The number of nodes in the tree will be between 2 and 100.
// Each node has a unique integer value from 1 to 100.
// Runtime: 72 ms, faster than 97.76% of JavaScript online submissions for Cousins in Binary Tree.
// Memory Usage: 40.5 MB, less than 22.02% of JavaScript online submissions for Cousins in Binary Tree.
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
 * @param {number} x
 * @param {number} y
 * @return {boolean}
 */
var isCousins = function (root, x, y) {
    let queue = [root];
    let foundX = false;
    let foundY = false;
    while (queue.length > 0) {
        let len = queue.length;
        for (let i = 0; i < len; i++) {
            let temp = queue.shift();
            if (temp.val == x) {
                foundX = true;
            } else if (temp.val == y) {
                foundY = true;
            }
            if (foundX && foundY) {
                return true;
            }
            if (temp.left != null && temp.right != null) {
                if (temp.left.val == x && temp.right.val == y) {
                    return false;
                } else if (temp.left.val == y && temp.right.val == x) {
                    return false;
                }
            }
            if (temp.left != null)
            queue.push(temp.left);
            if (temp.right != null)
            queue.push(temp.right);
        }
        foundX = false;
        foundY = false;
    }
    return false;
}