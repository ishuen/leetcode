// 939. Minimum Area Rectangle
// Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.
//
// If there isn't any rectangle, return 0.
//
// Example 1:
//
// Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
// Output: 4
// Example 2:
//
// Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
// Output: 2
//
// Note:
//
// 1 <= points.length <= 500
// 0 <= points[i][0] <= 40000
// 0 <= points[i][1] <= 40000
// All points are distinct.
//
// Runtime: 317 ms, faster than 55.36% of Java online submissions for Minimum Area Rectangle.
// Memory Usage: 114.4 MB, less than 9.35% of Java online submissions for Minimum Area Rectangle.
class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            Set<Integer> ySet = edges.getOrDefault(points[i][0], new HashSet<Integer>());
            ySet.add(points[i][1]);
            edges.put(points[i][0], ySet);
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] || points[i][1] == points[j][1]) continue;
                if (edges.get(points[i][0]).contains(points[j][1]) && edges.get(points[j][0]).contains(points[i][1])) {
                    int area = Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]);
                    if (area < min) min = area;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

