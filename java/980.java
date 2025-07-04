// 980. Unique Paths III
// On a 2-dimensional grid, there are 4 types of squares:
//
// 1 represents the starting square.  There is exactly one starting square.
// 2 represents the ending square.  There is exactly one ending square.
// 0 represents empty squares we can walk over.
// -1 represents obstacles that we cannot walk over.
// Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
//
//
//
// Example 1:
//
// Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
// Output: 2
// Explanation: We have the following two paths:
// 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
// 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
// Example 2:
//
// Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
// Output: 4
// Explanation: We have the following four paths:
// 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
// 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
// 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
// 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
// Example 3:
//
// Input: [[0,1],[2,0]]
// Output: 0
// Explanation:
// There is no path that walks over every empty square exactly once.
// Note that the starting and ending square can be anywhere in the grid.
//
//
// Note:
//
// 1 <= grid.length * grid[0].length <= 20
//
// Runtime: 2 ms, faster than 21.43% of Java online submissions for Unique Paths III.
// Memory Usage: 36.3 MB, less than 54.85% of Java online submissions for Unique Paths III.
class Solution {
    public int uniquePathsIII(int[][] grid) {
        boolean hasZero = false;
        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    hasZero = true;
                } else if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        if (hasZero == false && isNextToTarget(startRow, startCol, 2, grid)) return 1;
        if (!isNextToTarget(startRow, startCol, 0, grid) && !isNextToTarget(startRow, startCol, 2, grid)) return 0;
        grid[startRow][startCol] = -1;
        int count = 0;
        if (startRow > 0 && grid[startRow - 1][startCol] == 0) {
            grid[startRow - 1][startCol] = 1;
            count += uniquePathsIII(grid);
            grid[startRow - 1][startCol] = 0;
        }
        if (startRow < grid.length - 1 && grid[startRow + 1][startCol] == 0) {
            grid[startRow + 1][startCol] = 1;
            count += uniquePathsIII(grid);
            grid[startRow + 1][startCol] = 0;
        }
        if (startCol > 0 && grid[startRow][startCol - 1] == 0) {
            grid[startRow][startCol - 1] = 1;
            count += uniquePathsIII(grid);
            grid[startRow][startCol - 1] = 0;
        }
        if (startCol < grid[0].length - 1 && grid[startRow][startCol + 1] == 0) {
            grid[startRow][startCol + 1] = 1;
            count += uniquePathsIII(grid);
            grid[startRow][startCol + 1] = 0;
        }
        return count;
    }
    
    private boolean isNextToTarget(int startRow, int startCol, int target, int[][] grid) {
        if (startRow > 0 && grid[startRow - 1][startCol] == target) return true;
        if (startRow < grid.length - 1 && grid[startRow + 1][startCol] == target) return true;
        if (startCol > 0 && grid[startRow][startCol - 1] == target) return true;
        if (startCol < grid[0].length - 1 && grid[startRow][startCol + 1] == target) return true;
        return false;
    }

}

// 1 -> -1
// take turn put the adjecent 0 to 1
// if there is no more 0 and beside 2 -> count++


// Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths III.
// Memory Usage: 36.4 MB, less than 48.23% of Java online submissions for Unique Paths III.
class Solution {
    public int uniquePathsIII(int[][] grid) {
        int zeroCount = 0;
        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    zeroCount++;
                } else if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        int count = uniquePathsIII(startRow, startCol, zeroCount, grid);
        return count;
    }
    
    public int uniquePathsIII(int startRow, int startCol, int zeroCount, int[][] grid) {
        if (zeroCount == 0 && isNextToTarget(startRow, startCol, 2, grid)) return 1;
        if (!isNextToTarget(startRow, startCol, 0, grid) && !isNextToTarget(startRow, startCol, 2, grid)) return 0;
        grid[startRow][startCol] = -1;
        int count = 0;
        if (startRow > 0 && grid[startRow - 1][startCol] == 0) {
            grid[startRow - 1][startCol] = 1;
            count += uniquePathsIII(startRow - 1, startCol, zeroCount - 1, grid);
            grid[startRow - 1][startCol] = 0;
        }
        if (startRow < grid.length - 1 && grid[startRow + 1][startCol] == 0) {
            grid[startRow + 1][startCol] = 1;
            count += uniquePathsIII(startRow + 1, startCol, zeroCount - 1, grid);
            grid[startRow + 1][startCol] = 0;
        }
        if (startCol > 0 && grid[startRow][startCol - 1] == 0) {
            grid[startRow][startCol - 1] = 1;
            count += uniquePathsIII(startRow, startCol - 1, zeroCount - 1, grid);
            grid[startRow][startCol - 1] = 0;
        }
        if (startCol < grid[0].length - 1 && grid[startRow][startCol + 1] == 0) {
            grid[startRow][startCol + 1] = 1;
            count += uniquePathsIII(startRow, startCol + 1, zeroCount - 1, grid);
            grid[startRow][startCol + 1] = 0;
        }
        return count;
    }
    
    private boolean isNextToTarget(int startRow, int startCol, int target, int[][] grid) {
        if (startRow > 0 && grid[startRow - 1][startCol] == target) return true;
        if (startRow < grid.length - 1 && grid[startRow + 1][startCol] == target) return true;
        if (startCol > 0 && grid[startRow][startCol - 1] == target) return true;
        if (startCol < grid[0].length - 1 && grid[startRow][startCol + 1] == target) return true;
        return false;
    }

}
