// 934. Shortest Bridge
//
// You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
//
// An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
//
// You may change 0's to 1's to connect the two islands to form one island.
//
// Return the smallest number of 0's you must flip to connect the two islands.
//
//
//
// Example 1:
//
// Input: grid = [[0,1],[1,0]]
// Output: 1
// Example 2:
//
// Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
// Output: 2
// Example 3:
//
// Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
// Output: 1
//
//
// Constraints:
//
// n == grid.length == grid[i].length
// 2 <= n <= 100
// grid[i][j] is either 0 or 1.
// There are exactly two islands in grid.
//
// Runtime 8 ms Beats 93.76%
// Memory 44.4 MB Beats 41.33%
class Solution {
    private int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int shortestBridge(int[][] grid) {
        int startRow = 0;
        int startCol = 0;
        boolean found = false;
        for (int i = 0; i < grid.length; i++) {
            if (found) break;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                    found = true;
                    break;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        dfs(startRow, startCol, grid, queue);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] cur = queue.remove();
                for (int i = 0; i < 4; i++) {
                    int nextRow = cur[0] + directions[i][0];
                    int nextCol = cur[1] + directions[i][1];
                    if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) continue;
                    if (grid[nextRow][nextCol] == 2 || grid[nextRow][nextCol] == -1) continue;
                    else if (grid[nextRow][nextCol] == 0) {
                        grid[nextRow][nextCol] = -1;
                    } else if (grid[nextRow][nextCol] == 1) {
                        return count;
                    }
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
            count++;
        }
        return -1;
    }

    private void dfs(int row, int col, int[][] grid, Queue<int[]> queue) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) {
            return;
        }
        grid[row][col] = 2;
        queue.add(new int[]{row, col});
        dfs(row + 1, col, grid, queue);
        dfs(row - 1, col, grid, queue);
        dfs(row, col + 1, grid, queue);
        dfs(row, col - 1, grid, queue);
    }
}

// 1. find 1st island
// 2. find all cells of 1st island, change it to 2, add to queue
// 3. add surronding cells to queue and check if it's another island