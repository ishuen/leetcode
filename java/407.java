// 407. Trapping Rain Water II
// Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.
//
//
//
// Example 1:
//
//
// Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
// Output: 4
// Explanation: After the rain, water is trapped between the blocks.
// We have two small pounds 1 and 3 units trapped.
// The total volume of water trapped is 4.
// Example 2:
//
//
// Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
// Output: 10
//
//
// Constraints:
//
// m == heightMap.length
// n == heightMap[i].length
// 1 <= m, n <= 200
// 0 <= heightMap[i][j] <= 2 * 104
//

// Runtime: 18 ms, faster than 60.38% of Java online submissions for Trapping Rain Water II.
// Memory Usage: 41.8 MB, less than 72.95% of Java online submissions for Trapping Rain Water II.
class Solution {
    public class Bar {
        int row;
        int col;
        int height;
        public Bar (int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<Bar> pq = new PriorityQueue<>((a, b) -> a.height - b.height);
        int lastCol = heightMap[0].length - 1;
        int lastRow = heightMap.length - 1;
        boolean[][] visited = new boolean[lastRow + 1][lastCol + 1];
        for (int i = 0; i < heightMap.length; i++) {
            visited[i][0] = true;
            visited[i][lastCol] = true;
            pq.add(new Bar(i, 0, heightMap[i][0]));
            pq.add(new Bar(i, lastCol, heightMap[i][lastCol]));
        }
        for (int i = 1; i < lastCol; i++) {
            visited[0][i] = true;
            visited[lastRow][i] = true;
            pq.add(new Bar(0, i, heightMap[0][i]));
            pq.add(new Bar(lastRow, i, heightMap[lastRow][i]));
        }
        int size = 0;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!pq.isEmpty()) {
            Bar cur = pq.remove();
            for (int i = 0; i < 4; i++) {
                int r = cur.row + directions[i][0];
                int c = cur.col + directions[i][1];
                if (r < 0 || r > lastRow || c < 0 || c > lastCol || visited[r][c] == true) continue;
                size = size + Math.max(0, cur.height - heightMap[r][c]);
                visited[r][c] = true;
                pq.add(new Bar(r, c, Math.max(cur.height, heightMap[r][c])));
            }
        }
        return size;
    }
}
