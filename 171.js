// 171. Excel Sheet Column Number
// Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.
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
// Input: columnTitle = "A"
// Output: 1
// Example 2:
//
// Input: columnTitle = "AB"
// Output: 28
// Example 3:
//
// Input: columnTitle = "ZY"
// Output: 701
// Example 4:
//
// Input: columnTitle = "FXSHRXW"
// Output: 2147483647
//
//
// Constraints:
//
// 1 <= columnTitle.length <= 7
// columnTitle consists only of uppercase English letters.
// columnTitle is in the range ["A", "FXSHRXW"].

// Runtime: 152 ms, faster than 5.13% of JavaScript online submissions for Excel Sheet Column Number.
// Memory Usage: 40 MB, less than 54.30% of JavaScript online submissions for Excel Sheet Column Number.
/**
 * @param {string} columnTitle
 * @return {number}
 */
var map = {
    'A': 1,
    'B': 2,
    'C': 3,
    'D': 4,
    'E': 5,
    'F': 6,
    'G': 7,
    'H': 8,
    'I': 9,
    'J': 10,
    'K': 11,
    'L': 12,
    'M': 13,
    'N': 14,
    'O': 15,
    'P': 16,
    'Q': 17,
    'R': 18,
    'S': 19,
    'T': 20,
    'U': 21,
    'V': 22,
    'W': 23,
    'X': 24,
    'Y': 25,
    'Z': 26
}
var titleToNumber = function(columnTitle) {
    var counter = 0;
    for (var i = 0; i < columnTitle.length; i++) {
        counter = counter * 26 + map[columnTitle.charAt(i)];
    }
    return counter;
};


// Runtime: 88 ms, faster than 93.71% of JavaScript online submissions for Excel Sheet Column Number.
// Memory Usage: 40.1 MB, less than 42.05% of JavaScript online submissions for Excel Sheet Column Number.
var map = {
    'A': 1,
    'B': 2,
    'C': 3,
    'D': 4,
    'E': 5,
    'F': 6,
    'G': 7,
    'H': 8,
    'I': 9,
    'J': 10,
    'K': 11,
    'L': 12,
    'M': 13,
    'N': 14,
    'O': 15,
    'P': 16,
    'Q': 17,
    'R': 18,
    'S': 19,
    'T': 20,
    'U': 21,
    'V': 22,
    'W': 23,
    'X': 24,
    'Y': 25,
    'Z': 26
}
var titleToNumber = function(columnTitle) {
    var counter = 0;
    for (var i = 0; i < columnTitle.length; i++) {
        counter = counter + Math.pow(26, columnTitle.length - i - 1) * map[columnTitle.charAt(i)];
    }
    return counter;
};