// 149. Max Points on a Line
// Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
//
// Example 1:
//
// Input: points = [[1,1],[2,2],[3,3]]
// Output: 3
// Example 2:
//
// Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
// Output: 4
//
// Constraints:
//
// 1 <= points.length <= 300
// points[i].length == 2
// -104 <= xi, yi <= 104
// All the points are unique.
//
// Runtime: 7 ms, faster than 77.02% of Java online submissions for Max Points on a Line.
// Memory Usage: 38.6 MB, less than 62.44% of Java online submissions for Max Points on a Line.
class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        int max = 0;
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            else return b[1] - a[1];
        });
        for (int i = 0; i < points.length; i++) {
            Map<Double, Set<int[]>> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int x = points[i][0] - points[j][0];
                double slope = Integer.MAX_VALUE;
                if (x != 0) {
                    slope = (double)(points[i][1] - points[j][1]) / x; 
                }
                Set<int[]> set = map.getOrDefault(slope, new HashSet<>());
                set.add(points[i]);
                set.add(points[j]);
                map.put(slope, set);
                if (set.size() > max) max = set.size();
            }
        }
        return max;
    }
}


