// 6. ZigZag Conversion
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

// Runtime: 2 ms, faster than 99.87% of Java online submissions for ZigZag Conversion.
// Memory Usage: 39.2 MB, less than 80.00% of Java online submissions for ZigZag Conversion.

// row = 3
// P [0,0], A[0,2], H[0,4],N[0,6] --> 0, 4, 8, 12
// A[1,0], P[1,1], L[1,2], S[1,3], I[1,4], I[1,5], G[1,6] --> 1, 3, 5, 7, 9, 11, 13
// Y[2,0], I[2,2], R[2,4] --> 2, 6, 10
// 1st row = 0 + 2 * n * (row - 1)
// 2nd row = 1 + 2 * n * (row - 1) & (2 (row - 1) - curRowIndex) + 2 * n * (row - 1)
// 3rd row = 2 + 2 * n * (row - 1)

// row = 4
// P[0,0], I[0,3], N[0,6] --> 0, 6, 12
// A[1,0], L[1,2], S[1,3], I[1,5], G[1,6] --> 1, 5, 7, 11, 13
// Y[2,0], A[2,1], H[2,3], R[2,4] --> 2, 4, 8, 10
// P[3,0], I[3,3] --> 3, 9
// 1st row = 0 + 2 * n * (row - 1)
// 2nd row = 1 + 2 * n * (row - 1) & (2 (row - 1) - curRowIndex) + 2 * n * (row - 1)
// 3rd row = 2 + 2 * n * (row - 1) & (2 (row - 1) - curRowIndex) + 2 * n * (row - 1)
// 4th row = 3 + 2 * n * (row - 1)

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder strBuilder = new StringBuilder();
        int lastIndex = s.length() - 1;
        for (int i = 0; i < numRows; i++) {
            int index = i;
            int counter = 0;
            while (index <= lastIndex) {
                strBuilder.append(s.charAt(index));
                if (counter == 0 && i != 0 && i != numRows - 1 && 2 * (numRows - 1) - i <= lastIndex) {
                    strBuilder.append(s.charAt(2 * (numRows - 1) - i));
                }
                counter++;
                index = i + counter * 2 * (numRows - 1);
                if (i != 0 && i != numRows - 1 && index <= lastIndex) {
                    strBuilder.append(s.charAt(index));
                    index = 2 * (numRows - 1) - i + counter * 2 * (numRows - 1);
                }
            }
        }
        return strBuilder.toString();
    }
}



// Runtime: 5 ms, faster than 73.63% of Java online submissions for ZigZag Conversion.
// Memory Usage: 39.5 MB, less than 55.77% of Java online submissions for ZigZag Conversion.
class Solution {
    public String convert(String s, int numRows) {
        if (numRows >= s.length() || numRows == 1) return s;
        char[] chars = s.toCharArray();
        StringBuilder[] rows = new StringBuilder[numRows];
        int rowNum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i < numRows) {
                rows[i] = new StringBuilder();
            }
            rowNum = i % (2 * numRows - 2);
            if (rowNum >= numRows) rowNum = 2 * numRows - 2 - rowNum;
            rows[rowNum].append(chars[i]);
        }
        for (int i = 1; i < numRows; i++) {
            rows[0].append(rows[i]);
        }
        return rows[0].toString();
    }
}


