// 1637. Widest Vertical Area Between Two Points Containing No Points
// Given n points on a 2D plane where points[i] = [xi, yi], Return the widest vertical area between two points such that no points are inside the area.
//
// A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height). The widest vertical area is the one with the maximum width.
//
// Note that points on the edge of a vertical area are not considered included in the area.
//
// Example 1:
//
// ​
// Input: points = [[8,7],[9,9],[7,4],[9,7]]
// Output: 1
// Explanation: Both the red and the blue area are optimal.
// Example 2:
//
// Input: points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
// Output: 3
//
//
// Constraints:
//
// n == points.length
// 2 <= n <= 105
// points[i].length == 2
// 0 <= xi, yi <= 109
//
// Runtime: 76 ms, faster than 8.85% of Java online submissions for Widest Vertical Area Between Two Points Containing No Points.
// Memory Usage: 97.9 MB, less than 6.68% of Java online submissions for Widest Vertical Area Between Two Points Containing No Points.
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Queue<Integer> xAxis = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            xAxis.offer(points[i][0]);
        }
        int maxGap = 0;
        int top = xAxis.poll();
        int cur = 0;
        int gap = 0;
        while(!xAxis.isEmpty()) {
            cur = xAxis.poll();
            if (cur == top) continue;
            gap = cur - top;
            if (gap > maxGap) maxGap = gap;
            top = cur;
        }
        return maxGap;
    }
}

// Runtime: 36 ms, faster than 55.90% of Java online submissions for Widest Vertical Area Between Two Points Containing No Points.
// Memory Usage: 68 MB, less than 33.39% of Java online submissions for Widest Vertical Area Between Two Points Containing No Points.
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (point1, point2) -> point1[0] - point2[0]);
        int maxGap = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] - points[i-1][0] > maxGap) maxGap = points[i][0] - points[i-1][0];
        }
        return maxGap;
    }
}