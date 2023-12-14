// 2482. Difference Between Ones and Zeros in Row and Column
//
// You are given a 0-indexed m x n binary matrix grid.
//
// A 0-indexed m x n difference matrix diff is created with the following procedure:
//
// Let the number of ones in the ith row be onesRowi.
// Let the number of ones in the jth column be onesColj.
// Let the number of zeros in the ith row be zerosRowi.
// Let the number of zeros in the jth column be zerosColj.
// diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj
// Return the difference matrix diff.
//
//
//
// Example 1:
//
//
// Input: grid = [[0,1,1],[1,0,1],[0,0,1]]
// Output: [[0,0,4],[0,0,4],[-2,-2,2]]
// Explanation:
// - diff[0][0] = onesRow0 + onesCol0 - zerosRow0 - zerosCol0 = 2 + 1 - 1 - 2 = 0
// - diff[0][1] = onesRow0 + onesCol1 - zerosRow0 - zerosCol1 = 2 + 1 - 1 - 2 = 0
// - diff[0][2] = onesRow0 + onesCol2 - zerosRow0 - zerosCol2 = 2 + 3 - 1 - 0 = 4
// - diff[1][0] = onesRow1 + onesCol0 - zerosRow1 - zerosCol0 = 2 + 1 - 1 - 2 = 0
// - diff[1][1] = onesRow1 + onesCol1 - zerosRow1 - zerosCol1 = 2 + 1 - 1 - 2 = 0
// - diff[1][2] = onesRow1 + onesCol2 - zerosRow1 - zerosCol2 = 2 + 3 - 1 - 0 = 4
// - diff[2][0] = onesRow2 + onesCol0 - zerosRow2 - zerosCol0 = 1 + 1 - 2 - 2 = -2
// - diff[2][1] = onesRow2 + onesCol1 - zerosRow2 - zerosCol1 = 1 + 1 - 2 - 2 = -2
// - diff[2][2] = onesRow2 + onesCol2 - zerosRow2 - zerosCol2 = 1 + 3 - 2 - 0 = 2
// Example 2:
//
//
// Input: grid = [[1,1,1],[1,1,1]]
// Output: [[5,5,5],[5,5,5]]
// Explanation:
// - diff[0][0] = onesRow0 + onesCol0 - zerosRow0 - zerosCol0 = 3 + 2 - 0 - 0 = 5
// - diff[0][1] = onesRow0 + onesCol1 - zerosRow0 - zerosCol1 = 3 + 2 - 0 - 0 = 5
// - diff[0][2] = onesRow0 + onesCol2 - zerosRow0 - zerosCol2 = 3 + 2 - 0 - 0 = 5
// - diff[1][0] = onesRow1 + onesCol0 - zerosRow1 - zerosCol0 = 3 + 2 - 0 - 0 = 5
// - diff[1][1] = onesRow1 + onesCol1 - zerosRow1 - zerosCol1 = 3 + 2 - 0 - 0 = 5
// - diff[1][2] = onesRow1 + onesCol2 - zerosRow1 - zerosCol2 = 3 + 2 - 0 - 0 = 5
//
//
// Constraints:
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 105
// 1 <= m * n <= 105
// grid[i][j] is either 0 or 1.
//
// Runtime 14 ms Beats 24.60% of users with Java
// Memory 75.52 MB Beats 34.95% of users with Java
class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] rowDiff = new int[grid.length];
        int[] colDiff = new int[grid[0].length];
        Arrays.fill(rowDiff, Integer.MAX_VALUE);
        Arrays.fill(colDiff, Integer.MAX_VALUE);
        int[][] ans = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            if (rowDiff[i] == Integer.MAX_VALUE) {
                rowDiff[i] = getRowDiff(i, grid);
            }
            for (int j = 0; j < grid[0].length; j++) {
                if (colDiff[j] == Integer.MAX_VALUE) {
                    colDiff[j] = getColDiff(j, grid);
                }
                ans[i][j] = rowDiff[i] + colDiff[j];
            }
        }
        return ans;
    }
    private int getRowDiff(int row, int[][] grid) {
        int zeros = 0;
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[row][j] == 0) {
                zeros++;
            }
        }
        return grid[0].length - 2 * zeros;
    }

    private int getColDiff(int col, int[][] grid) {
        int zeros = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == 0) {
                zeros++;
            }
        }
        return grid.length - 2 * zeros;
    }
}


// Runtime 9 ms Beats 66.67% of users with Java
// Memory 73.33 MB Beats 42.40% of users with Java
class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] rowDiff = new int[grid.length];
        int[] colDiff = new int[grid[0].length];
        Arrays.fill(rowDiff, Integer.MAX_VALUE);
        Arrays.fill(colDiff, Integer.MAX_VALUE);
        for (int i = 0; i < grid.length; i++) {
            if (rowDiff[i] == Integer.MAX_VALUE) {
                rowDiff[i] = getRowDiff(i, grid);
            }
            for (int j = 0; j < grid[0].length; j++) {
                if (colDiff[j] == Integer.MAX_VALUE) {
                    colDiff[j] = getColDiff(j, grid);
                }
                grid[i][j] = rowDiff[i] + colDiff[j];
            }
        }
        return grid;
    }
    private int getRowDiff(int row, int[][] grid) {
        int zeros = 0;
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[row][j] == 0) {
                zeros++;
            }
        }
        return grid[0].length - 2 * zeros;
    }

    private int getColDiff(int col, int[][] grid) {
        int zeros = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == 0) {
                zeros++;
            }
        }
        return grid.length - 2 * zeros;
    }
}


// Runtime 8 ms Beats 70.87% of users with Java
// Memory 73.22 MB Beats 44.66% of users with Java
class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] rowDiff = new int[grid.length];
        int[] colDiff = new int[grid[0].length];
        Arrays.fill(rowDiff, grid[0].length);
        Arrays.fill(colDiff, grid.length);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    rowDiff[i] = rowDiff[i] - 2;
                    colDiff[j] = colDiff[j] - 2;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = rowDiff[i] + colDiff[j];
            }
        }
        return grid;
    }
}