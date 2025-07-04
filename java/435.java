// 435. Non-overlapping Intervals
// Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
//
//
//
// Example 1:
//
// Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
// Output: 1
// Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
// Example 2:
//
// Input: intervals = [[1,2],[1,2],[1,2]]
// Output: 2
// Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
// Example 3:
//
// Input: intervals = [[1,2],[2,3]]
// Output: 0
// Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
//
//
// Constraints:
//
// 1 <= intervals.length <= 105
// intervals[i].length == 2
// -5 * 104 <= starti < endi <= 5 * 104
//
// Runtime: 70 ms, faster than 17.11% of Java online submissions for Non-overlapping Intervals.
// Memory Usage: 115.1 MB, less than 5.06% of Java online submissions for Non-overlapping Intervals.
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)  return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 1;
        int prev = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prev) {
                count++;
                prev = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}