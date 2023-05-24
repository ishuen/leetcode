// 861. Score After Flipping Matrix
// You are given an m x n binary matrix grid.
//
// A move consists of choosing any row or column and toggling each value in that row or column (i.e., changing all 0's to 1's, and all 1's to 0's).
//
// Every row of the matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.
//
// Return the highest possible score after making any number of moves (including zero moves).
//
//
//
// Example 1:
//
//
// Input: grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
// Output: 39
// Explanation: 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
// Example 2:
//
// Input: grid = [[0]]
// Output: 1
//
//
// Constraints:
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 20
// grid[i][j] is either 0 or 1.
//
// Runtime 0 ms Beats 100%
// Memory 40.3 MB Beats 85.91%
class Solution {
    public int matrixScore(int[][] grid) {
        int sum = grid.length * (int) Math.pow(2, grid[0].length - 1);
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] != 0) {
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] = grid[i][j] == 0 ? 1 : 0;
                }
            }
        }
        for (int i = 1; i < grid[0].length; i++) {
            int count1 = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) count1++;
            }
            if (count1 * 2 < grid.length) {
                count1 = grid.length - count1;
            }
            sum = sum + count1 * (int) Math.pow(2, grid[0].length - i - 1);
        }
        return sum;
    }
}

// col: get as many 1 as possible
// row: get as many 1 at left as possible