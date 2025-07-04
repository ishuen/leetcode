// 435. Non-overlapping Intervals
//
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
//
// Runtime 189 ms Beats 81.45% of users with JavaScript
// Memory 74.82 MB Beats 66.67% of users with JavaScript
/**
 * @param {number[][]} intervals
 * @return {number}
 */
var eraseOverlapIntervals = function(intervals) {
    if (intervals.length == 0) return 0;
    intervals.sort((a, b) => a[1] - b[1]);
    let count = 1;
    let right = intervals[0][1];
    for (let i = 1; i < intervals.length; i++) {
        if (intervals[i][0] >= right) {
            right = intervals[i][1];
            count++;
        }
    }
    return intervals.length - count;
};