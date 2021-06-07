// 85. Maximal Rectangle
// Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
//
// Example 1:
// Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// Output: 6
// Explanation: The maximal rectangle is shown in the above picture.
// Example 2:
//
// Input: matrix = []
// Output: 0
// Example 3:
//
// Input: matrix = [["0"]]
// Output: 0
// Example 4:
//
// Input: matrix = [["1"]]
// Output: 1
// Example 5:
//
// Input: matrix = [["0","0"]]
// Output: 0
//
//
// Constraints:
//
// rows == matrix.length
// cols == matrix[i].length
// 0 <= row, cols <= 200
// matrix[i][j] is '0' or '1'.
//
// Runtime: 27 ms, faster than 6.90% of Java online submissions for Maximal Rectangle.
// Memory Usage: 48.2 MB, less than 5.08% of Java online submissions for Maximal Rectangle.
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int[] height = new int[colNum + 1];
        height[colNum] = 0;
        int max = 0;

        Stack<Integer> s = new Stack<Integer>();
        for (int row = 0; row < rowNum; row++) {
            for (int i = 0; i < colNum + 1; i++) {
                if (i < colNum)
                    if (matrix[row][i] == '1')
                        height[i] += 1;
                    else height[i] = 0;

                if (s.isEmpty() || height[i] >= height[s.peek()])
                    s.push(i);
                else {
                    int top = 0;
                    int area = 0;
                    while(!s.isEmpty() && height[i] < height[s.peek()]){
                        top = s.pop();
                        area = height[top] * (s.isEmpty() ? i : (i - s.peek() - 1));
                        if (area > max)
                            max = area;
                    }
                    s.push(i);
                }
            }
            s.clear();
        }
        return max;
    }
}

