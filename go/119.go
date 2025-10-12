// 119. Pascal's Triangle II

// Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

// Example 1:

// Input: rowIndex = 3
// Output: [1,3,3,1]
// Example 2:

// Input: rowIndex = 0
// Output: [1]
// Example 3:

// Input: rowIndex = 1
// Output: [1,1]
 

// Constraints:

// 0 <= rowIndex <= 33
 

// Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?

// Runtime 0 ms Beats 100.00%
// Memory 4.12 MB Beats 18.04%
func getRow(rowIndex int) []int {
    firstRow := []int{1}
    if rowIndex == 0 {
        return firstRow
    }
    secondRow := []int{1, 1}
    if rowIndex == 1 {
        return secondRow
    }
    lastRow := secondRow
    for i := 2; i <= rowIndex; i++ {
        newRow := []int{1}
        for j := 1; j < i; j++ {
            newRow = append(newRow, lastRow[j - 1] + lastRow[j])
        }
        newRow = append(newRow, 1)
        lastRow = newRow
    }
    return lastRow
}