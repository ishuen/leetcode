# 205. Isomorphic Strings
# Given two strings s and t, determine if they are isomorphic.
#
# Two strings are isomorphic if the characters in s can be replaced to get t.
#
# All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
#
# Example 1:
#
# Input: s = "egg", t = "add"
# Output: true
# Example 2:
#
# Input: s = "foo", t = "bar"
# Output: false
# Example 3:
#
# Input: s = "paper", t = "title"
# Output: true
# Note:
# You may assume both s and t have the same length.
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
// 60 ms, faster than 85.88%
var isIsomorphic = function(s, t) {
  var result = true;
  var obj = {};
  for (var i = 0; i < s.length; i++) {
    if (obj[t[i]] != undefined) {
      if (s[i] != obj[t[i]]) {
        result = false;
      }
    } else {
      if (Object.values(obj).indexOf(s[i]) > -1) {
        result = false;
      } else {
        obj[t[i]] = s[i];
      }
    }
  }
  return result;
};