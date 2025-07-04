// 554. Brick Wall
// There is a rectangular brick wall in front of you with n rows of bricks. The ith row has some number of bricks each of the same height (i.e., one unit) but they can be of different widths. The total width of each row is the same.
//
// Draw a vertical line from the top to the bottom and cross the least bricks. If your line goes through the edge of a brick, then the brick is not considered as crossed. You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
//
// Given the 2D array wall that contains the information about the wall, return the minimum number of crossed bricks after drawing such a vertical line.
//
//
//
// Example 1:
//
//
// Input: wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
// Output: 2
// Example 2:
//
// Input: wall = [[1],[1],[1]]
// Output: 3
//
//
// Constraints:
//
// n == wall.length
// 1 <= n <= 104
// 1 <= wall[i].length <= 104
// 1 <= sum(wall[i].length) <= 2 * 104
// sum(wall[i]) is the same for each row i.
// 1 <= wall[i][j] <= 231 - 1
//
// Runtime: 7 ms, faster than 99.20% of Java online submissions for Brick Wall.
// Memory Usage: 42 MB, less than 51.74% of Java online submissions for Brick Wall.
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int row = wall.size();
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < row; i++) {
            int cur = 0;
            List<Integer> list = wall.get(i);
            for (int j = 0; j < list.size() - 1; j++) {
                cur += list.get(j);
                int count = map.getOrDefault(cur, 0);
                count++;
                map.put(cur, count);
                if (count > max) max = count;
            }
        }
        return row - max;
    }
}

