// 72. Edit Distance
// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
//
// You have the following three operations permitted on a word:
//
// Insert a character
// Delete a character
// Replace a character
//
//
// Example 1:
//
// Input: word1 = "horse", word2 = "ros"
// Output: 3
// Explanation:
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')
// Example 2:
//
// Input: word1 = "intention", word2 = "execution"
// Output: 5
// Explanation:
// intention -> inention (remove 't')
// inention -> enention (replace 'i' with 'e')
// enention -> exention (replace 'n' with 'x')
// exention -> exection (replace 'n' with 'c')
// exection -> execution (insert 'u')
//
//
// Constraints:
//
// 0 <= word1.length, word2.length <= 500
// word1 and word2 consist of lowercase English letters.
//
// Runtime: 8 ms, faster than 16.37% of Java online submissions for Edit Distance.
// Memory Usage: 41.6 MB, less than 6.53% of Java online submissions for Edit Distance.
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] table = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            table[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); i++) {
            table[0][i] = i;
        }
        for (int i = 0; i < word1.length(); i++) {
            for(int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    table[i + 1][j + 1] = table[i][j];
                } else {
                    table[i + 1][j + 1] = 1 + Math.min(Math.min(table[i][j], table[i + 1][j]), table[i][j + 1]);
                }
            }
        }
        return table[word1.length()][word2.length()];
    }
}

//     h o r s e r
//    (1 2 3 4 5 6)
// 1 r 1 2 2 3 4 5
// 2 o 2 1 2 3 4 5
// 3 s 3 2 2 2 3 4

