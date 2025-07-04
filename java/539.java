// 539. Minimum Time Difference
// Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.
//
//
// Example 1:
//
// Input: timePoints = ["23:59","00:00"]
// Output: 1
// Example 2:
//
// Input: timePoints = ["00:00","23:59","00:00"]
// Output: 0
//
//
// Constraints:
//
// 2 <= timePoints <= 2 * 104
// timePoints[i] is in the format "HH:MM".
// Runtime: 2 ms, faster than 93.12% of Java online submissions for Minimum Time Difference.
// Memory Usage: 38.5 MB, less than 93.76% of Java online submissions for Minimum Time Difference.
class Solution {
    public int findMinDifference(List<String> timePoints) {
        PriorityQueue<Integer> times = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (String point: timePoints) {
            int second = Integer.parseInt(point.substring(0, 2)) * 60 + Integer.parseInt(point.substring(3));
            if (set.contains(second)) return 0;
            set.add(second);
            times.add(second - 1440);
            times.add(second);
        }
        int prev = times.remove();
        int min = 2880;
        while (!times.isEmpty()) {
            int cur = times.remove();
            if (cur - prev < min) min = cur - prev;
            prev = cur;
        }
        return min;
    }
}

// Runtime: 4 ms, faster than 72.48% of Java online submissions for Minimum Time Difference.
// Memory Usage: 38.7 MB, less than 83.52% of Java online submissions for Minimum Time Difference.
class Solution {
    public int findMinDifference(List<String> timePoints) {
        TreeSet<Integer> times = new TreeSet<>();
        for (String point: timePoints) {
            int second = Integer.parseInt(point.substring(0, 2)) * 60 + Integer.parseInt(point.substring(3));
            if (times.contains(second)) return 0;
            times.add(second - 1440);
            times.add(second);
        }
        int prev = times.first();
        times.remove(prev);
        int min = 2880;
        while (!times.isEmpty()) {
            int cur = times.first();
            times.remove(cur);
            if (cur - prev < min) min = cur - prev;
            prev = cur;
        }
        return min;
    }
}