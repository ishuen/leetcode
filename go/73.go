// 73. Set Matrix Zeroes

// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// You must do it in place.

 

// Example 1:


// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
// Example 2:


// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

// Constraints:

// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1
 

// Follow up:

// A straightforward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?

// Runtime 0 ms Beats 100.00%
// Memory 7.87 MB Beats 57.37%
func setZeroes(matrix [][]int)  {
    rows := make([]bool, len(matrix))
    cols := make([]bool, len(matrix[0]))
    for i := 0; i < len(matrix); i++ {
        for j := 0; j < len(matrix[0]); j++ {
            if matrix[i][j] == 0 {
                rows[i] = true
                cols[j] = true
            }
        }
    }
    for index := range(rows) {
        if rows[index] == true {
            setRow0(index, matrix)
        }
    }
    for index := range(cols) {
        if cols[index] == true {
            setCol0(index, matrix)
        }
    }
}

func setRow0 (row int, matrix [][]int) {
    for i := 0; i < len(matrix[0]); i++ {
        matrix[row][i] = 0
    }
}

func setCol0 (col int, matrix [][]int) {
    for i := 0; i < len(matrix); i++ {
        matrix[i][col] = 0
    }
}