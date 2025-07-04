// 883. Projection Area of 3D Shapes
//   On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the x, y, and z axes.
//   Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
//   Now we view the projection of these cubes onto the xy, yz, and zx planes.
//   A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane.
//   Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.
//   Return the total area of all three projections.
//
//   Example 1:
//   Input: [[2]]
//   Output: 5
//
//   Example 2:
//   Input: [[1,2],[3,4]]
//   Output: 17
//   Explanation:
//   Here are the three projections ("shadows") of the shape made with each axis-aligned plane.
//
//   Example 3:
//   Input: [[1,0],[0,2]]
//   Output: 8
//
//   Example 4:
//   Input: [[1,1,1],[1,0,1],[1,1,1]]
//   Output: 14
//
//   Example 5:
//   Input: [[2,2,2],[2,1,2],[2,2,2]]
//   Output: 21
//
//   Note:
//   1 <= grid.length = grid[0].length <= 50
//   0 <= grid[i][j] <= 50

// Runtime: 3 ms, faster than 15.21% of Java online submissions for Projection Area of 3D Shapes.
// Memory Usage: 39.2 MB, less than 100.00% of Java online submissions for Projection Area of 3D Shapes.
public class Solution {
  public int projectionArea(int[][] grid) {
    int bottom = 0;
    int col = 0;
    int[] maxRow = grid[0].clone();
    for (int i = 0; i < grid.length; i++) {
      int maxCol = 0;
      for (int j = 0; j < grid.length; j++) {
        if (grid[i][j] != 0) {
          bottom++;
        }
        if (grid[i][j] > maxCol) {
          maxCol = grid[i][j];
        }
        if (grid[i][j] > maxRow[j]) {
          maxRow[j] = grid[i][j];
        }
      }
      col = col + maxCol;
    }
    int row = Arrays.stream(maxRow).sum();
    return bottom + col + row;
  }
}

// Runtime: 1 ms, faster than 99.68% of Java online submissions for Projection Area of 3D Shapes.
// Memory Usage: 39.4 MB, less than 100.00% of Java online submissions for Projection Area of 3D Shapes.

public class Solution {
  public int projectionArea(int[][] grid) {
    int bottom = 0;
    int col = 0;
    int[] maxRow = grid[0].clone();
    for (int i = 0; i < grid.length; i++) {
      int maxCol = 0;
      for (int j = 0; j < grid.length; j++) {
        if (grid[i][j] != 0) {
          bottom++;
        }
        if (grid[i][j] > maxCol) {
          maxCol = grid[i][j];
        }
        if (grid[i][j] > maxRow[j]) {
          maxRow[j] = grid[i][j];
        }
      }
      col = col + maxCol;
    }
    int row = 0;
    for (int v: maxRow) {
      row = row + v;
    }
    return bottom + col + row;
  }
}