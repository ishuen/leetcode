// 688. Knight Probability in Chessboard
// On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).
//
// A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.
//
//
// Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.
//
// The knight continues moving until it has made exactly k moves or has moved off the chessboard.
//
// Return the probability that the knight remains on the board after it has stopped moving.
//
//
//
// Example 1:
//
// Input: n = 3, k = 2, row = 0, column = 0
// Output: 0.06250
// Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
// From each of those positions, there are also two moves that will keep the knight on the board.
// The total probability the knight stays on the board is 0.0625.
// Example 2:
//
// Input: n = 1, k = 0, row = 0, column = 0
// Output: 1.00000
//
//
// Constraints:
//
// 1 <= n <= 25
// 0 <= k <= 100
// 0 <= row, column <= n - 1
//
// Runtime 6 ms Beats 75.81%
// Memory 42.3 MB Beats 38.5%
class Solution {
    private int[][] moves = new int[][]{{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}};
    private double[][][] memory;
    public double knightProbability(int n, int k, int row, int column) {
        memory = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(memory[i][j], -1);
            }
        }
        double prob = solve(n, k, row, column);
        return prob;
    }
    public double solve(int n, int k, int row, int column) {
        if (row < 0 || row >= n || column < 0 || column >= n) return 0;
        if (k == 0) return 1;
        if (memory[row][column][k] != -1) return memory[row][column][k];
        double prob = 0;
        for (int i = 0; i < 8; i++) {
            prob = prob + (double) 1 / 8 * solve(n, k - 1, row + moves[i][0], column + moves[i][1]);
        }
        memory[row][column][k] = prob;
        return prob;
    }
}

// r - 2, c -1
// r - 1, c - 2
// r + 1, c - 2
// r + 2, c - 1
// r - 2, c + 1
// r - 1, c + 2
// r + 1, c + 2