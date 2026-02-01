3537. Fill a Special Grid

You are given a non-negative integer n representing a 2n x 2n grid. You must fill the grid with integers from 0 to 22n - 1 to make it special. A grid is special if it satisfies all the following conditions:

All numbers in the top-right quadrant are smaller than those in the bottom-right quadrant.
All numbers in the bottom-right quadrant are smaller than those in the bottom-left quadrant.
All numbers in the bottom-left quadrant are smaller than those in the top-left quadrant.
Each of its quadrants is also a special grid.
Return the special 2n x 2n grid.

Note: Any 1x1 grid is special.

 

Example 1:

Input: n = 0

Output: [[0]]

Explanation:

The only number that can be placed is 0, and there is only one possible position in the grid.

Example 2:

Input: n = 1

Output: [[3,0],[2,1]]

Explanation:

The numbers in each quadrant are:

Top-right: 0
Bottom-right: 1
Bottom-left: 2
Top-left: 3
Since 0 < 1 < 2 < 3, this satisfies the given constraints.

Example 3:

Input: n = 2

Output: [[15,12,3,0],[14,13,2,1],[11,8,7,4],[10,9,6,5]]

Explanation:



The numbers in each quadrant are:

Top-right: 3, 0, 2, 1
Bottom-right: 7, 4, 6, 5
Bottom-left: 11, 8, 10, 9
Top-left: 15, 12, 14, 13
max(3, 0, 2, 1) < min(7, 4, 6, 5)
max(7, 4, 6, 5) < min(11, 8, 10, 9)
max(11, 8, 10, 9) < min(15, 12, 14, 13)
This satisfies the first three requirements. Additionally, each quadrant is also a special grid. Thus, this is a special grid.

 

Constraints:

0 <= n <= 10


// Runtime 4 ms Beats 57.14%
// Memory 39.85 MB Beats 100.00%
func fill(startNum, endNum, up, bottom, left, right int, matrix [][]int) {
    if endNum - startNum > 3 {
        interval := (endNum - startNum + 1) / 4
        fill(startNum, startNum + interval - 1, up, (bottom + up) / 2, (left + right) / 2 + 1, right, matrix)
        fill(startNum + interval, startNum + 2 * interval - 1, (up + bottom) / 2 + 1, bottom, (left + right)/2 + 1, right, matrix)
        fill(startNum + 2 * interval, startNum + 3 * interval - 1, (up + bottom) / 2 + 1, bottom, left, (left + right) / 2, matrix)
        fill(startNum + 3 * interval, endNum, up, (up + bottom) / 2, left, (left + right) / 2, matrix)
    } else {
        matrix[up][left] = endNum
        matrix[up][right] = startNum
        matrix[bottom][right] = startNum + 1
        matrix[bottom][left] = startNum + 2
    }
}

func specialGrid(n int) [][]int {
    if n == 0 {
        return [][]int{{0}}
    }
    length := int(math.Pow(float64(2), float64(n)))
    matrix := make([][]int, length)
    for i := range length {
        matrix[i] = make([]int, length)
    }
    fill(0, length * length - 1, 0, length - 1, 0, length - 1, matrix)
    return matrix
}


// Runtime 4 ms Beats 57.14%
// Memory 47.31 MB Beats 71.43%
func fill(topRow, topCol, length, minValue int, matrix [][]int) {
    if length == 1 {
        matrix[topRow][topCol] = minValue
        return
    }
    nextLength := length / 2
    interval := nextLength * nextLength
    fill(topRow, topCol, nextLength, minValue + 3 * interval, matrix)
    fill(topRow, topCol + nextLength, nextLength, minValue, matrix)
    fill(topRow + nextLength, topCol, nextLength, minValue + 2 * interval, matrix)
    fill(topRow + nextLength, topCol + nextLength, nextLength, minValue + interval, matrix)
}

func specialGrid(n int) [][]int {
    if n == 0 {
        return [][]int{{0}}
    }
    length := 1 << n
    matrix := make([][]int, length)
    for i := range length {
        matrix[i] = make([]int, length)
    }
    fill(0, 0, length, 0, matrix)
    return matrix
}