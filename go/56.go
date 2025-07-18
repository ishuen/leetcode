// 56. Merge Intervals

// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

// Constraints:

// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104


// Runtime 1 ms Beats 81.40%
// Memory 8.70 MB Beats 14.52%
func merge(intervals [][]int) [][]int {
    sort.Slice(intervals, func (i, j int) bool {
        return intervals[i][0] < intervals[j][0]
    })
    output := [][]int{}
    current := intervals[0]
    for i := 1; i < len(intervals); i++ {
        if intervals[i][0] > current[1] {
            output = append(output, current)
            current = intervals[i]
        } else if intervals[i][0] <= current[1] && intervals[i][1] > current[1] {
                current[1] = intervals[i][1]
        }
    }
    output = append(output, current)
    return output
}