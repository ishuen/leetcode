// 624. Maximum Distance in Arrays

// You are given m arrays, where each array is sorted in ascending order.

// You can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a - b|.

// Return the maximum distance.

 

// Example 1:

// Input: arrays = [[1,2,3],[4,5],[1,2,3]]
// Output: 4
// Explanation: One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
// Example 2:

// Input: arrays = [[1],[1]]
// Output: 0
 

// Constraints:

// m == arrays.length
// 2 <= m <= 105
// 1 <= arrays[i].length <= 500
// -104 <= arrays[i][j] <= 104
// arrays[i] is sorted in ascending order.
// There will be at most 105 integers in all the arrays.

// Runtime 3 ms Beats 12.90%
// Memory 19.06 MB Beats 6.45%
func maxDistance(arrays [][]int) int {
    var maxDiff float64 = 0
    maxNum := arrays[0][len(arrays[0]) - 1]
    minNum := arrays[0][0]
    for i := 1; i < len(arrays); i++ {
        maxDiff = max(maxDiff, math.Abs(float64(minNum - arrays[i][len(arrays[i]) - 1])))
        maxDiff = max(maxDiff, math.Abs(float64(maxNum - arrays[i][0])))
        minNum = min(minNum, arrays[i][0])
        maxNum = max(maxNum, arrays[i][len(arrays[i]) - 1])
    }
    return int(maxDiff)
}