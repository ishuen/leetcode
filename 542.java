// 542. 01 Matrix
// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
//
// The distance between two adjacent cells is 1.
//
// Example 1:
//
//
// Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
// Output: [[0,0,0],[0,1,0],[0,0,0]]
// Example 2:
//
//
// Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
// Output: [[0,0,0],[0,1,0],[1,2,1]]
//
//
// Constraints:
//
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 104
// 1 <= m * n <= 104
// mat[i][j] is either 0 or 1.
// There is at least one 0 in mat.
//
// Runtime: 16 ms, faster than 43.55% of Java online submissions for 01 Matrix.
// Memory Usage: 41.6 MB, less than 71.22% of Java online submissions for 01 Matrix.
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> cells = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    cells.offer(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!cells.isEmpty()) {
            int[] cell = cells.poll();
            int r = cell[0];
            int c = cell[1];
            if (r > 0 && mat[r - 1][c] > mat[r][c]) {
                mat[r -1][c] = mat[r][c] + 1;
                cells.offer(new int[]{r - 1, c});
            }
            if (c > 0 && mat[r][c - 1] > mat[r][c]) {
                mat[r][c - 1] = mat[r][c] + 1;
                cells.offer(new int[]{r, c - 1});
            }
            if (r < mat.length - 1 && mat[r + 1][c] > mat[r][c]) {
                mat[r + 1][c] = mat[r][c] + 1;
                cells.offer(new int[]{r + 1, c});
            }
            if (c < mat[0].length - 1 && mat[r][c + 1] > mat[r][c]) {
                mat[r][c + 1] = mat[r][c] + 1;
                cells.offer(new int[]{r, c + 1});
            }
        }
        return mat;
    }
}