// 6. Zigzag Conversion

// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"

// Write the code that will take a string and make this conversion given a number of rows:

// string convert(string s, int numRows);
 

// Example 1:

// Input: s = "PAYPALISHIRING", numRows = 3
// Output: "PAHNAPLSIIGYIR"
// Example 2:

// Input: s = "PAYPALISHIRING", numRows = 4
// Output: "PINALSIGYAHRPI"
// Explanation:
// P     I    N
// A   L S  I G
// Y A   H R
// P     I
// Example 3:

// Input: s = "A", numRows = 1
// Output: "A"
 

// Constraints:

// 1 <= s.length <= 1000
// s consists of English letters (lower-case and upper-case), ',' and '.'.
// 1 <= numRows <= 1000

// Runtime 7 ms Beats 50.70%
// Memory 7.18 MB Beats 85.11%
func convert(s string, numRows int) string {
    if numRows == 1 {
        return s
    }
    row := 0
    isGoDown := true
    list := make([]string, numRows)
    for _, char := range s {
        list[row] = list[row] + string(char)
        if row == 0 && isGoDown == false {
            isGoDown = true
        } else if row == numRows - 1 && isGoDown == true {
            isGoDown = false
        }
        if isGoDown == true {
            row++
        } else {
            row--
        }
    }
    return strings.Join(list, "")
}

// Runtime 2 ms Beats 82.39%
// Memory 8.16 MB Beats 68.46%
func convert(s string, numRows int) string {
    if numRows == 1 {
        return s
    }
    row := 0
    isGoDown := true
    list := make([]strings.Builder, numRows)
    for _, char := range s {
        list[row].WriteByte(byte(char))
        if row == 0 && isGoDown == false {
            isGoDown = true
        } else if row == numRows - 1 && isGoDown == true {
            isGoDown = false
        }
        if isGoDown == true {
            row++
        } else {
            row--
        }
    }
    for i := 1; i < len(list); i++ {
        list[0].WriteString(list[i].String())
    }
    return list[0].String()
}