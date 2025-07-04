// 661. Image Smoother
//
// An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by rounding down the average of the cell and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother). If one or more of the surrounding cells of a cell is not present, we do not consider it in the average (i.e., the average of the four cells in the red smoother).
//
//
// Given an m x n integer matrix img representing the grayscale of an image, return the image after applying the smoother on each cell of it.
//
//
//
// Example 1:
//
//
// Input: img = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[0,0,0],[0,0,0],[0,0,0]]
// Explanation:
// For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
// For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
// For the point (1,1): floor(8/9) = floor(0.88888889) = 0
// Example 2:
//
//
// Input: img = [[100,200,100],[200,50,200],[100,200,100]]
// Output: [[137,141,137],[141,138,141],[137,141,137]]
// Explanation:
// For the points (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
// For the points (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
// For the point (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
//
//
// Constraints:
//
// m == img.length
// n == img[i].length
// 1 <= m, n <= 200
// 0 <= img[i][j] <= 255
//
// Runtime 8 ms Beats 28.73% of users with Java
// Memory 44.26 MB Beats 85.91% of users with Java
class Solution {
    public int[][] imageSmoother(int[][] img) {
        int row = img.length;
        int col = img[0].length;
        int[][] prefixSum = new int[row][col];
        int[][] output = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    prefixSum[i][j] = img[i][j];
                } else if (i == 0) {
                    prefixSum[i][j] = prefixSum[i][j - 1] + img[i][j];
                } else if (j == 0) {
                    prefixSum[i][j] = prefixSum[i - 1][j] + img[i][j];
                } else {
                    prefixSum[i][j] = prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1] + img[i][j];
                }
            }
        }
        for (int i = 0; i < row; i++) {
            int top = Math.max(i - 1, 0);
            int down = Math.min(i + 1, row - 1);
            for (int j = 0; j < col; j++) {
                int left = Math.max(j - 1, 0);
                int right = Math.min(j + 1, col - 1);
                output[i][j] = prefixSum[down][right];
                if (top > 0) {
                    output[i][j] = output[i][j] - prefixSum[top - 1][right];
                }
                if (left > 0) {
                    output[i][j] = output[i][j] - prefixSum[down][left - 1];
                }
                if (top > 0 && left > 0) {
                    output[i][j] = output[i][j] + prefixSum[top - 1][left - 1];
                }
                output[i][j] = output[i][j] / ((down - top + 1) * (right - left + 1));
            }
        }
        return output;
    }
}