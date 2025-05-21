// 1145. Binary Tree Coloring Game
//
// Two players play a turn based game on a binary tree. We are given the root of this binary tree, and the number of nodes n in the tree. n is odd, and each node has a distinct value from 1 to n.
//
// Initially, the first player names a value x with 1 <= x <= n, and the second player names a value y with 1 <= y <= n and y != x. The first player colors the node with value x red, and the second player colors the node with value y blue.
//
// Then, the players take turns starting with the first player. In each turn, that player chooses a node of their color (red if player 1, blue if player 2) and colors an uncolored neighbor of the chosen node (either the left child, right child, or parent of the chosen node.)
//
// If (and only if) a player cannot choose such a node in this way, they must pass their turn. If both players pass their turn, the game ends, and the winner is the player that colored more nodes.
//
// You are the second player. If it is possible to choose such a y to ensure you win the game, return true. If it is not possible, return false.
//
//
//
// Example 1:
//
//
// Input: root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
// Output: true
// Explanation: The second player can choose the node with value 2.
// Example 2:
//
// Input: root = [1,2,3], n = 3, x = 1
// Output: false
//
//
// Constraints:
//
// The number of nodes in the tree is n.
// 1 <= x <= n <= 100
// n is odd.
// 1 <= Node.val <= n
// All the values of the tree are unique.
//
// Runtime 0 ms Beats 100.00%
// Memory 58.14 MB Beats 50.00%
/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

function btreeGameWinningMove(root: TreeNode | null, n: number, x: number): boolean {
    let leftCount = 0
    let rightCount = 0
    function count(root: TreeNode | null, stop?: number): number {
        if (root === null) return 0
        if (stop && root.val == stop) {
            leftCount = count(root.left)
            rightCount = count(root.right)
            return 0
        }
        return 1 + count(root.left, stop) + count(root.right, stop)
    }

    let freeNodes = count(root, x)
    return freeNodes >= n / 2 || leftCount > n / 2 || rightCount > n / 2
};