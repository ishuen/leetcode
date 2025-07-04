// 1091. Shortest Path in Binary Matrix
// Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
//
// A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
//
// All the visited cells of the path are 0.
// All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
// The length of a clear path is the number of visited cells of this path.
//
//
//
// Example 1:
//
//
// Input: grid = [[0,1],[1,0]]
// Output: 2
// Example 2:
//
//
// Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
// Output: 4
// Example 3:
//
// Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
// Output: -1
//
//
// Constraints:
//
// n == grid.length
// n == grid[i].length
// 1 <= n <= 100
// grid[i][j] is 0 or 1
//
// Runtime 13 ms Beats 90.25%
// Memory 44.8 MB Beats 22.14%
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int len = grid.length;
        if (grid[0][0] != 0 || grid[len - 1][len - 1] != 0) return -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        grid[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            if (cur[0] == len - 1 && cur[1] == len - 1) return cur[2];
            for (int[] direction: directions) {
                int nextRow = cur[0] + direction[0];
                int nextCol = cur[1] + direction[1];
                if (nextRow >= grid.length || nextRow < 0 || nextCol >= grid.length || nextCol < 0) continue;
                if (grid[nextRow][nextCol] == 0) {
                    queue.add(new int[] {nextRow, nextCol, cur[2] + 1});
                    grid[nextRow][nextCol] = 1;
                }
            }
        }
        return -1;
    }
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
}
