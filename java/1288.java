// 1288. Remove Covered Intervals
//
// Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that are covered by another interval in the list.
//
// The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.
//
// Return the number of remaining intervals.
//
//
//
// Example 1:
//
// Input: intervals = [[1,4],[3,6],[2,8]]
// Output: 2
// Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
// Example 2:
//
// Input: intervals = [[1,4],[2,3]]
// Output: 1
//
//
// Constraints:
//
// 1 <= intervals.length <= 1000
// intervals[i].length == 2
// 0 <= li < ri <= 105
// All the given intervals are unique.
//
// Runtime 18ms Beats 5.01%of users with Java
// Memory 43.88MB Beats 8.06%of users with Java
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int total = intervals.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            boolean isCovered = false;
            Map<Integer, Integer> headMap = map.headMap(intervals[i][0]);
            for (int right: headMap.values()) {
                if (right >= intervals[i][1]) {
                    isCovered = true;
                    total--;
                    break;
                }
            }

            Map<Integer, Integer> tailMap = map.tailMap(intervals[i][0]);
            List<Integer> toRemove = new ArrayList<>();
            for (int left: tailMap.keySet()) {
                if (tailMap.get(left) <= intervals[i][1]) {
                    total--;
                    toRemove.add(left);
                }
            }

            for (int l: toRemove) {
                map.remove(l);
            }

            if (isCovered == false) {
                map.put(intervals[i][0], intervals[i][1]);
            } 
        }
        return total;
    }
}

// Runtime 6ms Beats 96.08%of users with Java
// Memory 42.89MB Beats 89.54%of users with Java
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int total = 0;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int left = -1;
        int right = -1;
        for (int[] interval: intervals) {
            if (interval[0] > left && interval[1] > right) {
                total++;
                left = interval[0];
            }
            right = Math.max(right, interval[1]);
        }
        return total;
    }
}