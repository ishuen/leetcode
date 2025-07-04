// 417. Pacific Atlantic Water Flow
// There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
//
// The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
//
// The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
//
// Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
//
//
//
// Example 1:
//
//
// Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
// Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// Example 2:
//
// Input: heights = [[2,1],[1,2]]
// Output: [[0,0],[0,1],[1,0],[1,1]]
//
//
// Constraints:
//
// m == heights.length
// n == heights[r].length
// 1 <= m, n <= 200
// 0 <= heights[r][c] <= 105
//
// Runtime: 7 ms, faster than 52.48% of Java online submissions for Pacific Atlantic Water Flow.
// Memory Usage: 39.9 MB, less than 85.21% of Java online submissions for Pacific Atlantic Water Flow.
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int width = heights.length;
        int height = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] pacific = new boolean[width][height];
        boolean[][] atlantic = new boolean[width][height];
        Queue<Integer[]> pQueue = new LinkedList<>();
        Queue<Integer[]> aQueue = new LinkedList<>();
        for (int i = 0; i < width; i++) {
            pacific[i][0] = true;
            atlantic[i][height - 1] = true;
            pQueue.add(new Integer[]{i, 0});
            aQueue.add(new Integer[]{i, height - 1});
        }
        for (int i = 0; i < height; i++) {
            pacific[0][i] = true;
            atlantic[width - 1][i] = true;
            pQueue.add(new Integer[]{0, i});
            aQueue.add(new Integer[]{width - 1, i});
        }
        findAccessible(heights, pQueue, pacific);
        findAccessible(heights, aQueue, atlantic);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (pacific[i][j] == true && atlantic[i][j] == true) {
                    ans.add(Arrays.asList(new Integer[] {i, j}));
                }
            }
        }
        return ans;
    }
    
    private void findAccessible(int[][] heights, Queue<Integer[]> queue, boolean[][] visited) {
        while(!queue.isEmpty()) {
            Integer[] cur = queue.remove();
            int row = cur[0];
            int col = cur[1];
            if (visited[row][col] == false) continue;
            if (row > 0 && heights[row - 1][col] >= heights[row][col]) {
                if (visited[row - 1][col] == false) queue.add(new Integer[]{row - 1, col});
                visited[row - 1][col] = true;
                
            }
            if (row < heights.length - 1 && heights[row + 1][col] >= heights[row][col]) {
                if (visited[row + 1][col]  == false) queue.add(new Integer[]{row + 1, col});
                visited[row + 1][col] = true;
            }
            if (col > 0 && heights[row][col - 1] >= heights[row][col]) {
                
                if (visited[row][col - 1] == false) queue.add(new Integer[]{row, col - 1});
                visited[row][col - 1] = true;
            }
            if (col < heights[0].length - 1 && heights[row][col + 1] >= heights[row][col]) {
                if (visited[row][col + 1] == false) queue.add(new Integer[]{row, col + 1});
                visited[row][col + 1] = true;
            }
        }
    }
}


