// 778. Swim in Rising Water
// You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).
//
// The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
//
// Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).
//
//
//
// Example 1:
//
//
// Input: grid = [[0,2],[1,3]]
// Output: 3
// Explanation:
// At time 0, you are in grid location (0, 0).
// You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
// You cannot reach point (1, 1) until time 3.
// When the depth of water is 3, we can swim anywhere inside the grid.
// Example 2:
//
//
// Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
// Output: 16
// Explanation: The final route is shown.
// We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
//
//
// Constraints:
//
// n == grid.length
// n == grid[i].length
// 1 <= n <= 50
// 0 <= grid[i][j] < n2
// Each value grid[i][j] is unique.
//
// Runtime: 16 ms, faster than 26.67% of Java online submissions for Swim in Rising Water.
// Memory Usage: 39 MB, less than 64.77% of Java online submissions for Swim in Rising Water.
class Solution {
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int swimInWater(int[][] grid) {
        int width = grid.length;
        boolean[][] visited = new boolean[width][width];
        PriorityQueue<int[]> nextCells = new PriorityQueue<>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        nextCells.add(new int[]{0, 0});
        visited[0][0] = true;
        int depth = 0;
        
        while(!nextCells.isEmpty()) {
            int[] cell = nextCells.remove();
            visited[cell[0]][cell[1]] = true;
            if (grid[cell[0]][cell[1]] > depth) depth = grid[cell[0]][cell[1]];
            if (cell[0] == width - 1 && cell[1] == width - 1) break;
            for (int i = 0; i < 4; i++) {
                if(cell[0] + directions[i][0] >= 0 && cell[0] + directions[i][0] < width && cell[1] + directions[i][1] >= 0 && cell[1] + directions[i][1] < width && visited[cell[0] + directions[i][0]][cell[1] + directions[i][1]] == false) {
                    nextCells.add(new int[]{cell[0] + directions[i][0], cell[1] + directions[i][1]});
                }
            }
        }
        return depth;
    }
}
// a matrix of visited
// priorityQueque<int[row, col]> for accessible cells
// sort by grid[row][col]