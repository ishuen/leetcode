// 151. Reverse Words in a String
// Given an input string, reverse the string word by word.
//
// Example:
//
// Input: "the sky is blue",
// Output: "blue is sky the".
// Note:
//
// A word is defined as a sequence of non-space characters.
// Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
// You need to reduce multiple spaces between two words to a single space in the reversed string.
// Follow up: For C programmers, try to solve it in-place in O(1) space.
//
// 52 ms, faster than 99.60%
/**
 * @param {string} str
 * @returns {string}
 */
var reverseWords = function(str) {
    var arr = str.split(" ");
    var len = arr.length;
    var res = arr[len - 1];
    for (var i = len - 2; i >= 0; i--) {
        if (arr[i] != "") {
            if (res != "") res = res + " " + arr[i];
            else res = res + arr[i];
        }
    }
    return res;
};