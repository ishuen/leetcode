// 1312. Minimum Insertion Steps to Make a String Palindrome
// Given a string s. In one step you can insert any character at any index of the string.
//
// Return the minimum number of steps to make s palindrome.
//
// A Palindrome String is one that reads the same backward as well as forward.
//
//
//
// Example 1:
//
// Input: s = "zzazz"
// Output: 0
// Explanation: The string "zzazz" is already palindrome we don't need any insertions.
// Example 2:
//
// Input: s = "mbadm"
// Output: 2
// Explanation: String can be "mbdadbm" or "mdbabdm".
// Example 3:
//
// Input: s = "leetcode"
// Output: 5
// Explanation: Inserting 5 characters the string becomes "leetcodocteel".
// Example 4:
//
// Input: s = "g"
// Output: 0
// Example 5:
//
// Input: s = "no"
// Output: 1
//
//
// Constraints:
//
// 1 <= s.length <= 500
// All characters of s are lower case English letters.
//
// Runtime: 27 ms, faster than 26.81% of Java online submissions for Minimum Insertion Steps to Make a String Palindrome.
// Memory Usage: 40.3 MB, less than 61.84% of Java online submissions for Minimum Insertion Steps to Make a String Palindrome.
class Solution {
    public int minInsertions(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        int common = findCommon(s, reversed);
        return s.length() - common;
    }
    
    private int findCommon(String s, String reversed) {
        int[][] matrix = new int[s.length() + 1][s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (s.charAt(i - 1) == reversed.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        return matrix[s.length()][s.length()];
    }
}

// if s is palindrome -> 0
// longest string s (-1) + s': mbadm mdabm

//   m b a d m
// m 1 1 1 1 1
// d 1 1 1 2 2
// a 1 1 2 2 2
// b 1 2 2 2 2
// m 1 2 2 2 3