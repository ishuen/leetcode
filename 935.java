// 935. Knight Dialer
//
// The chess knight has a unique movement, it may move two squares vertically and one square horizontally, or two squares horizontally and one square vertically (with both forming the shape of an L). The possible movements of chess knight are shown in this diagaram:
//
// A chess knight can move as indicated in the chess diagram below:
//
//
// We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell (i.e. blue cell).
//
//
// Given an integer n, return how many distinct phone numbers of length n we can dial.
//
// You are allowed to place the knight on any numeric cell initially and then you should perform n - 1 jumps to dial a number of length n. All jumps should be valid knight jumps.
//
// As the answer may be very large, return the answer modulo 109 + 7.
//
//
//
// Example 1:
//
// Input: n = 1
// Output: 10
// Explanation: We need to dial a number of length 1, so placing the knight over any numeric cell of the 10 cells is sufficient.
// Example 2:
//
// Input: n = 2
// Output: 20
// Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]
// Example 3:
//
// Input: n = 3131
// Output: 136006598
// Explanation: Please take care of the mod.
//
//
// Constraints:
//
// 1 <= n <= 5000
//
// Runtime 311 ms Beats 14.13%
// Memory 44.2 MB Beats 19.2%
class Solution {
    long MOD = (long)Math.pow(10, 9) + 7;
	private long[][][] memory;
    public int knightDialer(int n) {
        long count = 0;
        memory = new long[n + 1][4][3];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                count = (count + findPath(i, j , n)) % MOD;
            }
        }
        return (int) count;
    }

    private long findPath(int row, int col, int n) {
        if (row < 0 || row > 3 || col < 0 || col >= 3 || (row == 3 && col != 1)) return 0;
        if (n == 1) {
            memory[n][row][col] = 1;
            return 1;
        }
        if (memory[n][row][col] > 0) return memory[n][row][col];
        memory[n][row][col] = findPath(row + 1, col + 2, n - 1) % MOD
        + findPath(row + 1, col - 2, n - 1) % MOD
        + findPath(row + 2, col + 1, n - 1) % MOD
        + findPath(row + 2, col - 1, n - 1) % MOD
        + findPath(row - 1, col + 2, n - 1) % MOD
        + findPath(row - 1, col - 2, n - 1) % MOD
        + findPath(row - 2, col + 1, n - 1) % MOD
        + findPath(row - 2, col - 1, n - 1) % MOD;
        return memory[n][row][col];
    }
}