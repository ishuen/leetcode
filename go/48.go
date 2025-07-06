// 48. Rotate Image

// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

// Example 1:


// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]
// Example 2:


// Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 

// Constraints:

// n == matrix.length == matrix[i].length
// 1 <= n <= 20
// -1000 <= matrix[i][j] <= 1000

// Runtime 0 ms Beats 100.00%
// Memory 4.31 MB Beats 3.40%
func rotate(matrix [][]int)  {
    queue := []int{}
    for i := 0; i < len(matrix); i++ {
        for j := 0; j < len(matrix[0]); j++ {
            queue = append(queue, matrix[i][j])
        }
    }
    for j := len(matrix[0]) - 1; j >= 0; j-- {
        for i := 0; i < len(matrix); i++ {
            matrix[i][j] = queue[0]
            queue = queue[1:]
        }
    }
}

// Runtime 0 ms Beats 100.00%
// Memory 4.07 MB Beats 98.08%
func rotate(matrix [][]int)  {
    width := len(matrix[0])
    for i := 0; i < len(matrix); i++ {
        for j := 0; j < i; j++ {
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        }
    }

    for j := 0; j < width / 2; j++ {
        for i := 0; i < len(matrix); i++ {
            matrix[i][j], matrix[i][width - 1 - j] = matrix[i][width - 1 - j], matrix[i][j]
        }
    }
}