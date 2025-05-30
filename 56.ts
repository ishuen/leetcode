// 56. Merge Intervals
//
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
//
//
//
// Example 1:
//
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// Example 2:
//
// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//
//
// Constraints:
//
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
//
// Runtime 12 ms Beats 39.00%
// Memory 64.68 MB Beats 85.88%
function merge(intervals: number[][]): number[][] {
    intervals.sort((a, b) => (a[0] - b[0]))
    let output = []
    while (intervals.length > 0) {
        let current = intervals.shift()
        while (intervals.length > 0 && intervals[0][0] <= current[1]) {
            let top = intervals.shift()
            current[1] = Math.max(current[1], top[1])
        }
        output.push(current)
    }
    return output
};