// 6. Zigzag Conversion
//
// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"
//
// Write the code that will take a string and make this conversion given a number of rows:
//
// string convert(string s, int numRows);
//
//
// Example 1:
//
// Input: s = "PAYPALISHIRING", numRows = 3
// Output: "PAHNAPLSIIGYIR"
// Example 2:
//
// Input: s = "PAYPALISHIRING", numRows = 4
// Output: "PINALSIGYAHRPI"
// Explanation:
// P     I    N
// A   L S  I G
// Y A   H R
// P     I
// Example 3:
//
// Input: s = "A", numRows = 1
// Output: "A"
//
//
// Constraints:
//
// 1 <= s.length <= 1000
// s consists of English letters (lower-case and upper-case), ',' and '.'.
// 1 <= numRows <= 1000
//
// Runtime 4 ms Beats 77.59%
// Memory 58.59 MB Beats 98.20%
function convert(s: string, numRows: number): string {
    if (numRows == 1) return s
    let temp = new Array(numRows).fill("")
    let isOdd = true
    let curRow = 0
    let firstRow = 0
    let lastRow = numRows - 1
    for (let pointer = 0; pointer < s.length; pointer++) {
        const curChar = s.charAt(pointer)
        temp[curRow] = `${temp[curRow]}${curChar}`
        if (isOdd) {
            curRow++
            if (curRow > lastRow) {
                curRow = lastRow - 1
                isOdd = false
            }
        } else {
            if (curRow === firstRow) {
                isOdd = true
                curRow++
            } else {
                curRow--
            }
        }
    }
    return temp.join("")