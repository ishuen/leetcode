// 832. Flipping an Image
// Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
//
// To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
//
// To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
//
// Example 1:
//
// Input: [[1,1,0],[1,0,1],[0,0,0]]
// Output: [[1,0,0],[0,1,0],[1,1,1]]
// Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
// Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
// Example 2:
//
// Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
// Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
// Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
// Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
// Notes:
//
// 1 <= A.length = A[0].length <= 20
// 0 <= A[i][j] <= 1
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Flipping an Image.
// Memory Usage: 39 MB, less than 88.16% of Java online submissions for Flipping an Image.
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] row : A) {
            int flipCount = row.length / 2;
            for (int i = 0; i < flipCount; i++) {
                int temp = row[i];
                row[i] = row[row.length - i - 1] == 1 ? 0 : 1;
                row[row.length -i - 1] = temp == 1 ? 0 : 1;
            }
            if (row.length % 2 == 1) {
                row[flipCount] = row[flipCount] == 1 ? 0 : 1;
            }
        }
        return A;
    }
}