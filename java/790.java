// 790. Domino and Tromino Tiling
// You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.
//
//
// Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.
//
// In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.
//
//
//
// Example 1:
//
//
// Input: n = 3
// Output: 5
// Explanation: The five different ways are show above.
// Example 2:
//
// Input: n = 1
// Output: 1
//
//
// Constraints:
//
// 1 <= n <= 1000
//
// Runtime 0 ms Beats 100%
// Memory 39.6 MB Beats 57.42%
class Solution {
    public int numTilings(int n) {
        int[] combinations = new int[n + 1];
        combinations[1] = 1;
        if (n == 1) return 1;
        combinations[2] = 2;
        if (n == 2) return combinations[2];
        combinations[3] = 5;
        for (int i = 4; i <= n; i++) {
            combinations[i] = (combinations[i - 3] + (combinations[i - 1] * 2) % 1000000007) % 1000000007;
        }
        return combinations[n];
    }
}