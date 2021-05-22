// 73. Set Matrix Zeroes
// Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
//
// Follow up:
//
// A straight forward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?
//
//
// Example 1:
//
//
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
// Example 2:
//
//
// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
//
//
// Constraints:
//
// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -2^31 <= matrix[i][j] <= 2^31 - 1
//
// Runtime: 1 ms, faster than 92.39% of Java online submissions for Set Matrix Zeroes.
// Memory Usage: 40.5 MB, less than 49.63% of Java online submissions for Set Matrix Zeroes.
class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowToChange = new HashSet<>();
        Set<Integer> colToChange = new HashSet<>();
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j <colCount; j++) {
                if (matrix[i][j] == 0) {
                    rowToChange.add(i);
                    colToChange.add(j);
                }
            }
        }
        Iterator rows = rowToChange.iterator();
        while(rows.hasNext()) {
            int row = (int) rows.next();
            for (int i = 0; i < colCount; i++) {
                matrix[row][i] = 0;
            }
        }
        Iterator cols = colToChange.iterator();
        while(cols.hasNext()) {
            int col = (int) cols.next();
            for (int i = 0; i < rowCount; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}