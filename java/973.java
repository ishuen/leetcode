// 973. K Closest Points to Origin
// Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
//
// The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
//
// You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
//
//
//
// Example 1:
//
//
// Input: points = [[1,3],[-2,2]], k = 1
// Output: [[-2,2]]
// Explanation:
// The distance between (1, 3) and the origin is sqrt(10).
// The distance between (-2, 2) and the origin is sqrt(8).
// Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
// We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
// Example 2:
//
// Input: points = [[3,3],[5,-1],[-2,4]], k = 2
// Output: [[3,3],[-2,4]]
// Explanation: The answer [[-2,4],[3,3]] would also be accepted.
//
//
// Constraints:
//
// 1 <= k <= points.length <= 104
// -104 < xi, yi < 104
//
// Runtime: 67 ms, faster than 7.14% of Java online submissions for K Closest Points to Origin.
// Memory Usage: 47.5 MB, less than 60.31% of Java online submissions for K Closest Points to Origin.
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<Double, Set<Integer>> map = new TreeMap<>();
        for (int i = 0; i < points.length; i++) {
            double distance = Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2);
            Set<Integer> indexSet = map.getOrDefault(distance, new HashSet<>());
            indexSet.add(i);
            map.put(distance, indexSet);
        }
        int[][] kPoints = new int[k][2];
        int count = 0;
        Iterator it = map.entrySet().iterator();
        while (count < k && it.hasNext()) {
            Map.Entry<Double, Set<Integer>> entry = (Map.Entry<Double, Set<Integer>>) it.next();
            Set<Integer> setPoints = entry.getValue();
            for (Integer point: setPoints) {
                kPoints[count] = points[point];
                count++;
                if (count == k) break;
            }
        }
        return kPoints;
    }
}

// TreeMap key: distance, value: point


// Runtime: 3 ms, faster than 98.53% of Java online submissions for K Closest Points to Origin.
// Memory Usage: 47.9 MB, less than 39.74% of Java online submissions for K Closest Points to Origin.
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int last = points.length - 1;
        int start = 0;
        while (start < last) {
            int pivotIndex = grouping(points, start, last);
            if (pivotIndex > k) {
                last = pivotIndex - 1;
            } else if (pivotIndex < k) {
                start = pivotIndex + 1;
            } else break;
        }
        return Arrays.copyOfRange(points, 0, k);
    }

    private int grouping(int[][] points, int left, int right) {
        int[] pivot = points[left];
        while (left < right) {
            while (left < right && compare(points[right], pivot) >= 0) right--;
            points[left] = points[right];
            while (left < right && compare(points[left], pivot) <= 0) left++;
            points[right] = points[left];
        }
        points[left] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}
