// 168. Excel Sheet Column Title
// Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
//
// For example:
//
// A -> 1
// B -> 2
// C -> 3
// ...
// Z -> 26
// AA -> 27
// AB -> 28
// ...
//
//
// Example 1:
//
// Input: columnNumber = 1
// Output: "A"
// Example 2:
//
// Input: columnNumber = 28
// Output: "AB"
// Example 3:
//
// Input: columnNumber = 701
// Output: "ZY"
// Example 4:
//
// Input: columnNumber = 2147483647
// Output: "FXSHRXW"
//
//
// Constraints:
//
// 1 <= columnNumber <= 231 - 1
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Excel Sheet Column Title.
// Memory Usage: 36.2 MB, less than 60.15% of Java online submissions for Excel Sheet Column Title.
class Solution {
    public String convertToTitle(int columnNumber) {
        if (columnNumber == 0) return "";
        char[] mapping = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                                    'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
                                    'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        StringBuilder sb = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--;
            int remainder = columnNumber % 26;
            sb.insert(0, mapping[remainder]);
            columnNumber = columnNumber / 26;
        }
        
        return sb.toString();
    }
}

// 0 - 25, A-Z
// 1 * 26 + 1
// 26 * 26 + 26