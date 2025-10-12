// 118. Pascal's Triangle

// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

// Example 1:

// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Example 2:

// Input: numRows = 1
// Output: [[1]]
 

// Constraints:

// 1 <= numRows <= 30

// Runtime 0 ms Beats 100.00%
// Memory 4.28 MB Beats 89.82%
func generate(numRows int) [][]int {
    output := make([][]int, 1)
    firstRow := []int{1}
    output[0] = firstRow
    if numRows == 1 {
        return output
    }
    secondRow := []int{1, 1}
    output = append(output, secondRow)
    if numRows == 2 {
        return output
    }
    lastRow := secondRow
    for i := 2; i < numRows; i++ {
        newRow := []int{1}
        for j := 1; j < i; j++ {
            newRow = append(newRow, lastRow[j - 1] + lastRow[j])
        }
        newRow = append(newRow, 1)
        output = append(output, newRow)
        lastRow = newRow
    }
    return output
}