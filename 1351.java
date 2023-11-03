// 1351. Count Negative Numbers in a Sorted Matrix
//
// Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
//
//
//
// Example 1:
//
// Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
// Output: 8
// Explanation: There are 8 negatives number in the matrix.
// Example 2:
//
// Input: grid = [[3,2],[1,0]]
// Output: 0
//
//
// Constraints:
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 100
// -100 <= grid[i][j] <= 100
//
//
// Follow up: Could you find an O(n + m) solution?
//
// Runtime 1ms Beats 56.93%of users with Java
// Memory 43.76MB Beats 61.12%of users with Java
class Solution {
    public int countNegatives(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int count = 0;
        for (int i = height - 1; i >= 0; i--) {
            for (int j = width - 1; j >= 0; j--) {
                if (grid[i][j] < 0) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}

// Runtime 0ms Beats 100.00%of users with Java
// Memory 43.52MB Beats 85.00%of users with Java
class Solution {
    public int countNegatives(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int count = 0;
        int j = width - 1;
        int i = 0;
        while (j >= 0) {
            if (grid[i][j] < 0) {
                count = count + (height - i);
                j--;
            } else {
                i++;
            }
            if (i >= height) break;
        }
        return count;
    }
}
