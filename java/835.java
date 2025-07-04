// 835. Image Overlap
// You are given two images, img1 and img2, represented as binary, square matrices of size n x n. A binary matrix has only 0s and 1s as values.
//
// We translate one image however we choose by sliding all the 1 bits left, right, up, and/or down any number of units. We then place it on top of the other image. We can then calculate the overlap by counting the number of positions that have a 1 in both images.
//
// Note also that a translation does not include any kind of rotation. Any 1 bits that are translated outside of the matrix borders are erased.
//
// Return the largest possible overlap.
//
//
//
// Example 1:
//
//
// Input: img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
// Output: 3
// Explanation: We translate img1 to right by 1 unit and down by 1 unit.
//
// The number of positions that have a 1 in both images is 3 (shown in red).
//
// Example 2:
//
// Input: img1 = [[1]], img2 = [[1]]
// Output: 1
// Example 3:
//
// Input: img1 = [[0]], img2 = [[0]]
// Output: 0
//
//
// Constraints:
//
// n == img1.length == img1[i].length
// n == img2.length == img2[i].length
// 1 <= n <= 30
// img1[i][j] is either 0 or 1.
// img2[i][j] is either 0 or 1.
//
// Runtime: 348 ms, faster than 5.51% of Java online submissions for Image Overlap.
// Memory Usage: 101.3 MB, less than 5.51% of Java online submissions for Image Overlap.
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<int[]> position1 = new ArrayList<>();
        List<int[]> position2 = new ArrayList<>();
        for (int i = 0; i < img1.length; i++) {
            for (int j = 0; j < img1[0].length; j++) {
                if (img1[i][j] == 1) position1.add(new int[]{i, j});
                if (img2[i][j] == 1) position2.add(new int[]{i, j});
            }
        }
        Map<String, Integer> overlaps = new HashMap<>();
        int max = 0;
        for (int[] p1: position1) {
            for (int[] p2: position2) {
                String key = (p1[0] - p2[0]) + "-" + (p1[1] - p2[1]);
                int count = overlaps.getOrDefault(key, 0) + 1;
                overlaps.put(key, count);
                if (count > max) max = count;
            }
        }
        return max;
    }
}

// Runtime: 62 ms, faster than 26.77% of Java online submissions for Image Overlap.
// Memory Usage: 39.6 MB, less than 23.62% of Java online submissions for Image Overlap.
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<Integer> position1 = new ArrayList<>();
        List<Integer> position2 = new ArrayList<>();
        for (int i = 0; i < img1.length; i++) {
            for (int j = 0; j < img1[0].length; j++) {
                if (img1[i][j] == 1) position1.add(i * 100 + j);
                if (img2[i][j] == 1) position2.add(i * 100 + j);
            }
        }
        Map<Integer, Integer> overlaps = new HashMap<>();
        int max = 0;
        for (int p1: position1) {
            for (int p2: position2) {
                int key = p1 - p2;
                int count = overlaps.getOrDefault(key, 0) + 1;
                overlaps.put(key, count);
                if (count > max) max = count;
            }
        }
        return max;
    }
}

// Runtime 31 ms Beats 88.17% Memory 42.6 MB Beats 43.20%
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int width = img1.length;
        int moves = 2 * width - 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= moves; i++) {
            for (int j = 1; j <= moves; j++) {
                max = Math.max(max, calculateOverlap(i, j, img1, img2));
            }
        }
        return max;
    }

    private int calculateOverlap(int row, int col, int[][] img1, int[][] img2) {
        int width = img1.length;
        int img1RowStart = row > width ? row - width : 0;
        int img1ColStart = col > width ? col - width : 0;
        int img2RowStart = row > width ? 0 : width - row;
        int img2ColStart = col > width ? 0 : width - col;
        int rowCount = row > width ? 2 * width - row : row;
        int colCount = col > width ? 2 * width - col : col;
        int count = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (img1[img1RowStart + i][img1ColStart + j] == 1 && img2[img2RowStart + i][img2ColStart + j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}