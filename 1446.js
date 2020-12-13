// 1446. Consecutive Characters

// Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.
//
// Return the power of the string.
//
//
// Example 1:
//
// Input: s = "leetcode"
// Output: 2
// Explanation: The substring "ee" is of length 2 with the character 'e' only.
// Example 2:
//
// Input: s = "abbcccddddeeeeedcba"
// Output: 5
// Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
// Example 3:
//
// Input: s = "triplepillooooow"
// Output: 5
// Example 4:
//
// Input: s = "hooraaaaaaaaaaay"
// Output: 11
// Example 5:
//
// Input: s = "tourist"
// Output: 1
//
//
// Constraints:
//
// 1 <= s.length <= 500
// s contains only lowercase English letters.


// Runtime: 72 ms, faster than 99.11% of JavaScript online submissions for Consecutive Characters.
// Memory Usage: 39.3 MB, less than 65.57% of JavaScript online submissions for Consecutive Characters.
/**
 * @param {string} s
 * @return {number}
 */
var maxPower = function(s) {
    let maxLen = 1;
    let curLen = 1;
    let cur = s[0]
    for (let i = 1; i < s.length; i++) {
        if (s[i] == cur) {
            curLen++;
            if (curLen > maxLen) {
                maxLen = curLen;
            }
        } else {
            curLen = 1;
            cur = s[i];
        }
    }
    return maxLen;
};