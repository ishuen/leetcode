// 59. Spiral Matrix II
// Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
//
// Example 1:
//
//
// Input: n = 3
// Output: [[1,2,3],[8,9,4],[7,6,5]]
// Example 2:
//
// Input: n = 1
// Output: [[1]]
//
// Constraints:
//
// 1 <= n <= 20
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
// Memory Usage: 37 MB, less than 73.28% of Java online submissions for Spiral Matrix II.
class Solution {
    public int[][] generateMatrix(int n) {
        int max = n * n;
        int counter = 1;
        boolean isToRight = true;
        boolean isToBottom = true;
        int row = 0;
        int col = 0;
        int start = 0;
        int last = n - 1;
        int[][] matrix = new int[n][n];
        while(counter <= max) {
            matrix[row][col] = counter;
            counter++;
            if (isToRight == true && isToBottom == true) {
                if (col == last) {
                    isToRight = false;
                    row++;
                } else col++;
            } else if (isToRight == false && isToBottom == true) {
                if (row == last) {
                    isToBottom = false;
                    col--;
                } else row++;
            } else if (isToRight == false && isToBottom == false) {
                if (col == start) {
                    isToRight = true;
                    row--;
                } else {
                    col--;
                }
            } else if (isToRight == true && isToBottom == false){
                if (row == start + 1) {
                    isToBottom = true;
                    start++;
                    last--;
                    col++;
                } else {
                    row--;
                }
            }
        }
        return matrix;
    }
}

// range
// direction isToRight: true/ false
//           isToBottom: true/ false

// right: isToRight = true, isToBottom = true;
// down: isToRight = false, isToBottom = true;
// left: isToRight = false, isToBottom = false;
// up: isToRight = true, isToBottom = false;

