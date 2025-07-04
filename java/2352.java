// 2352. Equal Row and Column Pairs
//
// Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
//
// A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
//
//
//
// Example 1:
//
//
// Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
// Output: 1
// Explanation: There is 1 equal row and column pair:
// - (Row 2, Column 1): [2,7,7]
// Example 2:
//
//
// Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
// Output: 3
// Explanation: There are 3 equal row and column pairs:
// - (Row 0, Column 0): [3,1,2,2]
// - (Row 2, Column 2): [2,4,2,2]
// - (Row 3, Column 2): [2,4,2,2]
//
//
// Constraints:
//
// n == grid.length == grid[i].length
// 1 <= n <= 200
// 1 <= grid[i][j] <= 105
//
// Runtime 64 ms Beats 29.03% of users with Java
// Memory 54.36 MB Beats 6.55% of users with Java
class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> colMap = new HashMap<>();
        for (int i = 0; i < grid[0].length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid.length; j++) {
                sb.append(grid[j][i] + "_");
            }
            String key = sb.toString();
            colMap.put(key, colMap.getOrDefault(key, 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid[0].length; j++) {
                sb.append(grid[i][j] + "_");
            }
            String key = sb.toString();
            count = count + colMap.getOrDefault(key, 0);
        }
        return count;
    }
}

// Runtime 52 ms Beats 35.61% of users with Java
// Memory 52.29 MB Beats 27.52% of users with Java
class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> colMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                sb.append(grid[j][i] + "_");
            }
            String key = sb.toString();
            colMap.put(key, colMap.getOrDefault(key, 0) + 1);
            sb.delete(0, sb.length());
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sb.append(grid[i][j] + "_");
            }
            count = count + colMap.getOrDefault(sb.toString(), 0);
            sb.delete(0, sb.length());
        }
        return count;
    }
}