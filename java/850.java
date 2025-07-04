// 850. Rectangle Area II
// You are given a 2D array of axis-aligned rectangles. Each rectangle[i] = [xi1, yi1, xi2, yi2] denotes the ith rectangle where (xi1, yi1) are the coordinates of the bottom-left corner, and (xi2, yi2) are the coordinates of the top-right corner.
//
// Calculate the total area covered by all rectangles in the plane. Any area covered by two or more rectangles should only be counted once.
//
// Return the total area. Since the answer may be too large, return it modulo 109 + 7.
//
//
//
// Example 1:
//
//
// Input: rectangles = [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
// Output: 6
// Explanation: A total area of 6 is covered by all three rectangles, as illustrated in the picture.
// From (1,1) to (2,2), the green and red rectangles overlap.
// From (1,0) to (2,3), all three rectangles overlap.
// Example 2:
//
// Input: rectangles = [[0,0,1000000000,1000000000]]
// Output: 49
// Explanation: The answer is 1018 modulo (109 + 7), which is 49.
//
//
// Constraints:
//
// 1 <= rectangles.length <= 200
// rectanges[i].length == 4
// 0 <= xi1, yi1, xi2, yi2 <= 109
// xi1 <= xi2
// yi1 <= yi2
//
//
// Runtime 5 ms Beats 63.16%
// Memory 42.1 MB Beats 82.46%
class Solution {
    public int rectangleArea(int[][] rectangles) {
      int mod = 1000000007;
      List<int[]> nonOverlappedList = new ArrayList<>();
      long area = 0;
      for (int[] rectangle: rectangles) {
          addNonOverlapped(rectangle, nonOverlappedList, 0);
      }
      for (int[] rectangle: nonOverlappedList) {
          area = (area + (long)(rectangle[2] - rectangle[0]) * (long)(rectangle[3] - rectangle[1])) % mod;
      }
      return (int)area % mod;
    }
    private void addNonOverlapped(int[] rectangle, List<int[]> nonOverlappedList, int startIndex) {
        if (startIndex >= nonOverlappedList.size()) {
            nonOverlappedList.add(rectangle);
            return;
        }
        int[] reference = nonOverlappedList.get(startIndex);
        // no overlap
        if (reference[0] > rectangle[2] || reference[1] > rectangle[3] || reference[2] < rectangle[0] || reference[3] < rectangle[1]) {
            addNonOverlapped(rectangle, nonOverlappedList, startIndex + 1);
            return;
        }
        if (reference[0] > rectangle[0]) {
            addNonOverlapped(new int[]{rectangle[0], rectangle[1], reference[0], rectangle[3]}, nonOverlappedList, startIndex + 1);
        }
        if (reference[1] > rectangle[1]) {
            addNonOverlapped(new int[]{Math.max(rectangle[0], reference[0]), rectangle[1], Math.min(rectangle[2], reference[2]), reference[1]}, nonOverlappedList, startIndex + 1);
        }
        if (reference[2] < rectangle[2]) {
            addNonOverlapped(new int[]{reference[2], rectangle[1], rectangle[2], rectangle[3]}, nonOverlappedList, startIndex + 1);
        }
        if (reference[3] < rectangle[3]) {
            addNonOverlapped(new int[]{Math.max(rectangle[0], reference[0]), reference[3], Math.min(rectangle[2], reference[2]), rectangle[3]}, nonOverlappedList, startIndex + 1);
        }
    }
}