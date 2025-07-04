// 576. Out of Boundary Paths
// There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.
//
// Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
//
//
//
// Example 1:
//
//
// Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
// Output: 6
// Example 2:
//
//
// Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
// Output: 12
//
//
// Constraints:
//
// 1 <= m, n <= 50
// 0 <= maxMove <= 50
// 0 <= startRow < m
// 0 <= startColumn < n
//
// Runtime: 18 ms, faster than 18.74% of Java online submissions for Out of Boundary Paths.
// Memory Usage: 39.5 MB, less than 18.52% of Java online submissions for Out of Boundary Paths.
class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) return 0;
        int[][][] counts = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            counts[i][0][1]++;
            counts[i][n - 1][1]++;
        }
        for (int i = 0; i < n; i++) {
            counts[0][i][1]++;
            counts[m - 1][i][1]++;
        }
        int count = counts[startRow][startColumn][1];
        for (int i = 2; i <= maxMove; i++) {
            findPaths(i, counts, m, n, maxMove);
            count = (count + counts[startRow][startColumn][i]) % mod;
        }
        return count;
    }
    
    private int mod = 1000000007;
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private void findPaths(int curMove, int[][][] counts, int m, int n, int maxMove) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    if (i + directions[k][0] >= m || i + directions[k][0] < 0 || j + directions[k][1] >= n || j + directions[k][1] < 0) continue;
                    counts[i][j][curMove] = (counts[i][j][curMove] + counts[i + directions[k][0]][j + directions[k][1]][curMove - 1]) % mod;
                    
                }
            }
        }
    }
}

// 1 [3 2 3]
// 2 [2 6 2]
// 3 [0 4 0]


// Runtime: 4 ms, faster than 76.91% of Java online submissions for Out of Boundary Paths.
// Memory Usage: 38.1 MB, less than 59.91% of Java online submissions for Out of Boundary Paths.
class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) return 0;
        int[][][] counts = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(counts[i][j], -1);
            }
        }
        return findPaths(maxMove, startRow, startColumn, counts, m, n, maxMove);
    }
    
    private int mod = 1000000007;
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private int findPaths(int remainedMove, int startRow, int startCol, int[][][] counts, int m, int n, int maxMove) {
        if (startRow < 0 || startRow >= m || startCol < 0 || startCol >= n) return 1;
        if (remainedMove == 0) return 0;
        if (counts[startRow][startCol][remainedMove] != -1) return counts[startRow][startCol][remainedMove];
        counts[startRow][startCol][remainedMove] = 0;
        for (int k = 0; k < 4; k++) {
            counts[startRow][startCol][remainedMove] = (counts[startRow][startCol][remainedMove] + findPaths(remainedMove - 1, startRow + directions[k][0], startCol + directions[k][1], counts, m, n, maxMove)) % mod;
        }
        return counts[startRow][startCol][remainedMove];
    }
}
