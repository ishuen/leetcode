// 885. Spiral Matrix III
// You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.
//
// You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.
//
// Return an array of coordinates representing the positions of the grid in the order you visited them.
//
//
//
// Example 1:
//
//
// Input: rows = 1, cols = 4, rStart = 0, cStart = 0
// Output: [[0,0],[0,1],[0,2],[0,3]]
// Example 2:
//
//
// Input: rows = 5, cols = 6, rStart = 1, cStart = 4
// Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
//
//
// Constraints:
//
// 1 <= rows, cols <= 100
// 0 <= rStart < rows
// 0 <= cStart < cols
//
// Runtime: 4 ms, faster than 43.85% of Java online submissions for Spiral Matrix III.
// Memory Usage: 40 MB, less than 72.09% of Java online submissions for Spiral Matrix III.
class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] cells = new int[rows * cols][2];
        cells[0] = new int[]{rStart, cStart};
        int rounds = Math.max(Math.max(rows - rStart, rStart + 1), Math.max(cols - cStart, cStart + 1));
        int index = 1;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 1; i <= rounds; i++) {
            for (int k = 0; k < 2; k++)
            for (int j = 0; j < 2 * i - 1; j++) {
                rStart += directions[k][0];
                cStart += directions[k][1];
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    cells[index] = new int[]{rStart, cStart};
                    index++;
                }
            }
            for (int k = 2; k < 4; k++)
            for (int j = 0; j < 2 * i; j++) {
                rStart += directions[k][0];
                cStart += directions[k][1];
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    cells[index] = new int[]{rStart, cStart};
                    index++;
                }
            }
        }
        return cells;
    }
}
