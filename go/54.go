// 54. Spiral Matrix

// Given an m x n matrix, return all elements of the matrix in spiral order.

 

// Example 1:


// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]
// Example 2:


// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

// Constraints:

// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100

// Runtime 0 ms Beats 100.00%
// Memory 4.04 MB Beats 8.08%
func spiralOrder(matrix [][]int) []int {
    left, right, up, down := 0, len(matrix[0]) - 1, 0, len(matrix) - 1
    ans := []int{}
    for ; left <= right && up <= down; {
        for i := left; i <= right; i++ {
            ans = append(ans, matrix[up][i])
        }
        for i := up + 1; i <= down; i++ {
            ans = append(ans, matrix[i][right])
        }
        if up == down {
            break
        }
        for i := right - 1; i > left; i-- {
            ans = append(ans, matrix[down][i])
        }
        if left == right {
            break
        }
        for i := down; i > up; i-- {
            ans = append(ans, matrix[i][left])
        }
        up++
        down--
        left++
        right--
    }
    return ans
}