// 1267. Count Servers that Communicate
//
// You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.
//
// Return the number of servers that communicate with any other server.
//
//
//
// Example 1:
//
//
//
// Input: grid = [[1,0],[0,1]]
// Output: 0
// Explanation: No servers can communicate with others.
// Example 2:
//
//
//
// Input: grid = [[1,0],[1,1]]
// Output: 3
// Explanation: All three servers can communicate with at least one other server.
// Example 3:
//
//
//
// Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
// Output: 4
// Explanation: The two servers in the first row can communicate with each other. The two servers in the third column can communicate with each other. The server at right bottom corner can't communicate with any other server.
//
//
// Constraints:
//
// m == grid.length
// n == grid[i].length
// 1 <= m <= 250
// 1 <= n <= 250
// grid[i][j] == 0 or 1
//
// Runtime 14ms Beats 10.18%of users with Java
// Memory 50.31MB Beats 7.08%of users with Java
class Solution {
    public int countServers(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    sum = sum + getConnected(i, j, grid);
                }
            }
        }
        return sum;
    }

    private int getConnected(int row, int col, int[][] grid) {
        int count = 0;
        boolean hasConnection = false;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == 1 && i != row) {
                count++;
                hasConnection = true;
                grid[i][col] = -1;
            } else if (grid[i][col] == -1 && i != row) {
                hasConnection = true;
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[row][i] == 1 && i != col) {
                count++;
                hasConnection = true;
                grid[row][i] = -1;
            } else if (grid[row][i] == -1 && i != col) {
                hasConnection = true;
            }
        }
        if (hasConnection) {
            if (grid[row][col] == 0) {
                grid[row][col] = -1;
                return count + 1;
            }
            return count;
        }
        return 0;
    }
}

// Runtime 3ms Beats 51.77%of users with Java
// Memory 49.30MB Beats 54.42%of users with Java
class Solution {
    public int countServers(int[][] grid) {
        int[] rowCount = new int[grid.length];
        int[] colCount = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    count++;
                }
            }
        }
        return count;
    }
}


