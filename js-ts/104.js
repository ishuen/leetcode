// 104. Maximum Depth of Binary Tree
//
// Given the root of a binary tree, return its maximum depth.
//
// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//
//
// Example 1:
//
//
// Input: root = [3,9,20,null,null,15,7]
// Output: 3
// Example 2:
//
// Input: root = [1,null,2]
// Output: 2
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [0, 104].
// -100 <= Node.val <= 100
//
//
// Runtime 114 ms Beats 5.04% of users with JavaScript
// Memory 45.46 MB Beats 35.44% of users with JavaScript
var maxDepth = function(root) {
    if (!root) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));  
};

// Runtime 88 ms Beats 5.63% of users with JavaScript
// Memory 45.36 MB Beats 42.81% of users with JavaScript
var maxDepth = function(root) {
    if (!root) return 0;
    let queue = [root];
    let count = 0;
    while (queue.length) {
        let size = queue.length;
        for (let i = 0; i < size; i++) {
            let cur = queue.shift();
            if (cur.left) {
                queue.push(cur.left);
            }
            if (cur.right) {
                queue.push(cur.right);
            }
        }
        count++;
    }
    return count;
};