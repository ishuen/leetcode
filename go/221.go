// 221. Maximal Square

// Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 

// Example 1:


// Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// Output: 4
// Example 2:


// Input: matrix = [["0","1"],["1","0"]]
// Output: 1
// Example 3:

// Input: matrix = [["0"]]
// Output: 0
 

// Constraints:

// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 300
// matrix[i][j] is '0' or '1'.

// Runtime 4 ms Beats 52.55%
// Memory 8.32 MB Beats 95.29%
func maximalSquare(matrix [][]byte) int {
    height := len(matrix)
    width := len(matrix[0]) 
    sizes := make([][]int, height + 1)
    for i := 0; i <= height; i++ {
        sizes[i] = make([]int, width + 1)
    }
    maxWidth := 0
    for i := 1; i <= height; i++ {
        for j := 1; j <= width; j++ {
            if matrix[i - 1][j - 1] == byte('1') {
                sizes[i][j] = min(sizes[i - 1][j - 1], sizes[i - 1][j], sizes[i][j - 1]) + 1
                maxWidth = max(maxWidth, sizes[i][j])
            }
        }
    }
    return maxWidth * maxWidth
}


// Runtime 1 ms Beats 89.41%
// Memory 9.05 MB Beats 41.18%
func maximalSquare(matrix [][]byte) int {
    if matrix == nil || len(matrix) == 0 || len(matrix[0]) == 0 {
        return 0
    }
    height := len(matrix)
    width := len(matrix[0]) 
    sizes := make([][]int, height + 1)
    for i := 0; i <= height; i++ {
        sizes[i] = make([]int, width + 1)
    }
    maxWidth := 0
    for i := 1; i <= height; i++ {
        for j := 1; j <= width; j++ {
            if matrix[i - 1][j - 1] == byte('1') {
                sizes[i][j] = min(sizes[i - 1][j - 1], sizes[i - 1][j], sizes[i][j - 1]) + 1
                maxWidth = max(maxWidth, sizes[i][j])
            }
        }
    }
    return maxWidth * maxWidth
}