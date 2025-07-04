// 963. Minimum Area Rectangle II
//
// You are given an array of points in the X-Y plane points where points[i] = [xi, yi].
//
// Return the minimum area of any rectangle formed from these points, with sides not necessarily parallel to the X and Y axes. If there is not any such rectangle, return 0.
//
// Answers within 10-5 of the actual answer will be accepted.
//
//
//
// Example 1:
//
//
// Input: points = [[1,2],[2,1],[1,0],[0,1]]
// Output: 2.00000
// Explanation: The minimum area rectangle occurs at [1,2],[2,1],[1,0],[0,1], with an area of 2.
// Example 2:
//
//
// Input: points = [[0,1],[2,1],[1,1],[1,0],[2,0]]
// Output: 1.00000
// Explanation: The minimum area rectangle occurs at [1,0],[1,1],[2,1],[2,0], with an area of 1.
// Example 3:
//
//
// Input: points = [[0,3],[1,2],[3,1],[1,3],[2,1]]
// Output: 0
// Explanation: There is no possible rectangle to form from these points.
//
//
// Constraints:
//
// 1 <= points.length <= 50
// points[i].length == 2
// 0 <= xi, yi <= 4 * 104
// All the given points are unique.
//
// Runtime 66 ms Beats 15.56%
// Memory 44.9 MB Beats 6.67%
class Solution {
    public double minAreaFreeRect(int[][] points) {
        if (points.length < 4) return 0.0;
        int len = points.length;
        Map<String, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                double distance = Math.pow((points[i][0] - points[j][0]), 2) + Math.pow((points[i][1] - points[j][1]), 2);
                double centerX = (double)(points[i][0] + points[j][0]) / 2;
                double centerY = (double)(points[i][1] + points[j][1]) / 2;
                String key = distance + "-" + centerX + "-" + centerY;
                List<int[]> list = map.getOrDefault(key, new ArrayList<>());
                list.add(new int[]{i, j});
                map.put(key, list);
            }
        }
        double minArea = Double.MAX_VALUE;
        for (String key: map.keySet()) {
            List<int[]> list = map.get(key);
            if (list.size() < 2) continue;
            for (int i = 0; i < list.size(); i++) {
                    int point1 = list.get(i)[0];
                    int point2 = list.get(i)[1];
                for (int j = i + 1; j < list.size(); j++) {
                    int point3 = list.get(j)[0];
                    double width = Math.sqrt(Math.pow((points[point3][0] - points[point1][0]), 2) + Math.pow((points[point3][1] - points[point1][1]), 2));
                    double height = Math.sqrt(Math.pow((points[point3][0] - points[point2][0]), 2) + Math.pow((points[point3][1] - points[point2][1]), 2));
                    minArea = Math.min(minArea, height * width);
                }
            }
        }
        return minArea == Double.MAX_VALUE ? 0.0 : minArea;
    }
}