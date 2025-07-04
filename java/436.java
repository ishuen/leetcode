// 436. Find Right Interval
// You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.
//
// The right interval for an interval i is an interval j such that startj >= endi and startj is minimized.
//
// Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.
//
//
//
// Example 1:
//
// Input: intervals = [[1,2]]
// Output: [-1]
// Explanation: There is only one interval in the collection, so it outputs -1.
// Example 2:
//
// Input: intervals = [[3,4],[2,3],[1,2]]
// Output: [-1,0,1]
// Explanation: There is no right interval for [3,4].
// The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
// The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
// Example 3:
//
// Input: intervals = [[1,4],[2,3],[3,4]]
// Output: [-1,2,-1]
// Explanation: There is no right interval for [1,4] and [3,4].
// The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.
//
//
// Constraints:
//
// 1 <= intervals.length <= 2 * 104
// intervals[i].length == 2
// -106 <= starti <= endi <= 106
// The start point of each interval is unique.
//
// Runtime: 26 ms, faster than 37.50% of Java online submissions for Find Right Interval.
// Memory Usage: 46.4 MB, less than 55.56% of Java online submissions for Find Right Interval.
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> starts = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            starts.put(intervals[i][0], i);
        }
        int[] arr = new int[intervals.length];
        for (int i = 0; i < arr.length; i++) {
            Integer key = starts.ceilingKey(intervals[i][1]);
            if (key == null) arr[i] = -1;
            else arr[i] = starts.get(key);
        }
        return arr;
    }
}

// TreeMap (key: start interval, value: index) search the ceiling key
// start interval and its index