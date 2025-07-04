// 994. Rotting Oranges
//
// You are given an m x n grid where each cell can have one of three values:
//
// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
//
// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
//
//
//
// Example 1:
//
//
// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
// Example 2:
//
// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
// Example 3:
//
// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
//
//
// Constraints:
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] is 0, 1, or 2.
//
// Runtime 2 ms Beats 85.42%
// Memory 41.5 MB Beats 79.64%
class Solution {
    private int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        int width = grid.length;
        int height = grid[0].length;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (grid[i][j] == 1) count++;
                else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (count == 0) return 0;
        if (queue.size() == 0) return -1;
        boolean[][] visited = new boolean[width][height];
        int minute = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean hasChange = false;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                for (int j = 0; j < 4; j++) {
                    int nextRow = cur[0] + directions[j][0];
                    int nextCol = cur[1] + directions[j][1];
                    if (nextRow >= width || nextRow < 0 || nextCol >= height || nextCol < 0) continue;
                    if (grid[nextRow][nextCol] == 1 && visited[nextRow][nextCol] == false) {
                        grid[nextRow][nextCol] = 2;
                        queue.add(new int[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                        count--;
                        hasChange = true;
                    }
                }
            }
            if (hasChange) minute++;
        }
        if (count == 0) return minute;
        return -1;
    }
}