// 892. Surface Area of 3D Shapes
// You are given an n x n grid where you have placed some 1 x 1 x 1 cubes. Each value v = grid[i][j] represents a tower of v cubes placed on top of cell (i, j).
//
// After placing these cubes, you have decided to glue any directly adjacent cubes to each other, forming several irregular 3D shapes.
//
// Return the total surface area of the resulting shapes.
//
// Note: The bottom face of each shape counts toward its surface area.
//
// Example 1:
//
//
// Input: grid = [[2]]
// Output: 10
// Example 2:
//
// Input: grid = [[1,2],[3,4]]
// Output: 34
// Example 3:
//
//
// Input: grid = [[1,0],[0,2]]
// Output: 16
// Example 4:
//
// Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
// Output: 32
// Example 5:
//
//
// Input: grid = [[2,2,2],[2,1,2],[2,2,2]]
// Output: 46
//
//
// Constraints:
//
// n == grid.length
// n == grid[i].length
// 1 <= n <= 50
// 0 <= grid[i][j] <= 50
//
// Runtime: 2 ms, faster than 95.38% of Java online submissions for Surface Area of 3D Shapes.
// Memory Usage: 38.6 MB, less than 63.87% of Java online submissions for Surface Area of 3D Shapes.
class Solution {
    public int surfaceArea(int[][] grid) {
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                area = area + 2 + 4 * grid[i][j];
                if (j > 0) {
                    area = area - 2 * Math.min(grid[i][j - 1], grid[i][j]);
                }
                if (i > 0) {
                    area = area - 2 * Math.min(grid[i - 1][j], grid[i][j]);
                }
            }
        }
        return area;
    }
}