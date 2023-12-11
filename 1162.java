// 1162. As Far from Land as Possible
//
// Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.
//
// The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
//
//
//
// Example 1:
//
//
// Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
// Output: 2
// Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.
// Example 2:
//
//
// Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
// Output: 4
// Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.
//
//
// Constraints:
//
// n == grid.length
// n == grid[i].length
// 1 <= n <= 100
// grid[i][j] is 0 or 1
//
// Runtime 11 ms Beats 93.35% of users with Java
// Memory 43.62 MB Beats 95.87% of users with Java
class Solution {
    public int maxDistance(int[][] grid) {
        int[][] matrix = new int[grid.length][grid[0].length];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    matrix[i][j] = 0;
                } else {
                    if (j > 0 && matrix[i][j - 1] != Integer.MAX_VALUE) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][j - 1] + 1);
                    }
                    if (i > 0 && matrix[i - 1][j] != Integer.MAX_VALUE) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i - 1][j] + 1);
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (j < grid[0].length - 1 && matrix[i][j + 1] != Integer.MAX_VALUE) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][j + 1] + 1);
                    }
                if (i < grid.length - 1 && matrix[i + 1][j] != Integer.MAX_VALUE) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i + 1][j] + 1);
                    }
                if (matrix[i][j] != Integer.MAX_VALUE) {
                    max = Math.max(max, matrix[i][j]);
                }   
            }
        }

        return max <= 0 ? -1: max;
    }
}

// Runtime 6 ms Beats 100.00% of users with Java
// Memory 43.76 MB Beats 93.81% of users with Java
class Solution {
    public int maxDistance(int[][] grid) {
        int sum = grid.length + grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                int left = sum;
                int top = sum;
                if (j > 0) {
                    left = grid[i][j - 1];
                }
                if (i > 0) {
                    top = grid[i - 1][j];
                }
                grid[i][j] = Math.min(left, top) + 1;
            }
        }

        int max = 1;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] == 1) continue;
                int right = sum;
                int bottom = sum;
                if (j < grid[0].length - 1) {
                    right = grid[i][j + 1];
                }
                if (i < grid.length - 1) {
                    bottom = grid[i + 1][j];
                }
                grid[i][j] = Math.min(grid[i][j], Math.min(right, bottom) + 1);
                max = Math.max(max, grid[i][j]);
            }
        }

        return max == 1 || max == sum + 2 ? -1 : max - 1;
    }
}