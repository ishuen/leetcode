// 840. Magic Squares In Grid
// A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
//
// Given a row x col grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).
//
//
//
// Example 1:
//
//
// Input: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
// Output: 1
// Explanation:
// The following subgrid is a 3 x 3 magic square:
//
// while this one is not:
//
// In total, there is only one magic square inside the given grid.
// Example 2:
//
// Input: grid = [[8]]
// Output: 0
//
//
// Constraints:
//
// row == grid.length
// col == grid[i].length
// 1 <= row, col <= 10
// 0 <= grid[i][j] <= 15
//
// Runtime 0 ms Beats 100%
// Memory 40 MB Beats 92.71%
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) return 0;
        int sum = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j <grid[0].length - 2; j++) {
                sum = checkSquare(i, j, grid) ? sum + 1: sum;
            }
        }
        return sum;
    }

    boolean checkSquare(int row, int col, int[][] grid) {
        if (!checkDistinct(row, col, grid)) {
            return false;
        }
        int rowSum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        int colSum = grid[row][col] + grid[row + 1][col] + grid[row + 2][col];
        int left = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int right = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];
        if (rowSum != colSum || left != rowSum || right != rowSum) return false;
        for (int i = 1; i < 3; i++) {
            int curRow = 0;
            int curCol = 0;
            for (int j = 0; j < 3; j++) {
                curRow = grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2];
                curCol = grid[row][col + i] + grid[row + 1][col + i] + grid[row + 2][col + i];
            }
            if (curRow != rowSum) return false;
            if (curCol != colSum) return false;
        }        
        return true;
    }

    boolean checkDistinct(int row, int col, int[][] grid) {
        boolean[] numbers = new boolean[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int number = grid[row + i][col + j];
                if (number > 9 || number == 0) return false;
                if (numbers[number - 1] == true) {
                    return false;
                }
                numbers[number - 1] = true;
            }
        }
        return true;
    }
}