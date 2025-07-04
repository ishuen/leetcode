// 73. Set Matrix Zeroes
//
// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
//
// You must do it in place.
//
//
//
// Example 1:
//
//
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
// Example 2:
//
//
// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
//
//
// Constraints:
//
// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1
//
//
// Follow up:
//
// A straightforward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?
//
//
// Runtime 2ms Beats 84.26%
// Memory 59.91 MB Beats 60.51%

/**
 Do not return anything, modify matrix in-place instead.
 */
function setZeroes(matrix: number[][]): void {
    let colToChange: number[] = []
    for (let i = 0; i < matrix.length; i++) {
        let is0Row = false
        for (let j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] == 0) {
                if (is0Row == false) {
                    is0Row = true
                    backPropRow(i, j, matrix)
                }
                if (!colToChange.includes(j)) {
                    colToChange.push(j)
                    backPropCol(i, j, matrix)
                }
            } else if (is0Row == true || colToChange.includes(j)) {
                matrix[i][j] = 0
            }
        }
    }
};

function backPropRow(row: number, col: number, matrix: number[][]): void {
    for (let i = 0; i < col; i++) {
        matrix[row][i] = 0
    }
}
function backPropCol(row: number, col: number, matrix: number[][]): void {
    for (let j = 0; j < row; j++) {
        matrix[j][col] = 0
    }
}

// Runtime 2ms Beats 84.26%
// Memory 60.25 MB Beats 45.06%
function setZeroes(matrix: number[][]): void {
    let has0Row = matrix[0][0] == 0
    let has0Col = matrix[0][0] == 0
    for (let i = 0; i < matrix[0].length; i++) {
        if (matrix[0][i] == 0) {
            has0Row = true
            break
        }
    }
    for (let i = 1; i < matrix.length; i++) {
        if (matrix[i][0] == 0) {
            has0Col = true
        }
        for (let j = 1; j < matrix[0].length; j++) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0
                matrix[0][j] = 0
            }
        }
        if (matrix[i][0] == 0) matrix[i].fill(0)
    }
    

    for (let i = 1; i < matrix[0].length; i++) {
        if (matrix[0][i] == 0) propCol(i, matrix)
    }
    if (has0Row == true) matrix[0].fill(0)
    if (has0Col == true) propCol(0, matrix)
};

function propCol(col: number, matrix: number[][]): void {
    for (let j = 0; j < matrix.length; j++) {
        matrix[j][col] = 0
    }
}