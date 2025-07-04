// 583. Delete Operation for Two Strings
// Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
//
// In one step, you can delete exactly one character in either string.
//
//
//
// Example 1:
//
// Input: word1 = "sea", word2 = "eat"
// Output: 2
// Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
// Example 2:
//
// Input: word1 = "leetcode", word2 = "etco"
// Output: 4
//
//
// Constraints:
//
// 1 <= word1.length, word2.length <= 500
// word1 and word2 consist of only lowercase English letters.
//
// Runtime 10 ms Beats 49.43%
// Memory 43.4 MB Beats 33.18%
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] matrix = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            matrix[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); i++) {
            matrix[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j-1]) + 1;
                }
            }
        }
        return matrix[word1.length()][word2.length()];
    }
}