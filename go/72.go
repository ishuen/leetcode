// 72. Edit Distance

// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

// You have the following three operations permitted on a word:

// Insert a character
// Delete a character
// Replace a character
 

// Example 1:

// Input: word1 = "horse", word2 = "ros"
// Output: 3
// Explanation: 
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')
// Example 2:

// Input: word1 = "intention", word2 = "execution"
// Output: 5
// Explanation: 
// intention -> inention (remove 't')
// inention -> enention (replace 'i' with 'e')
// enention -> exention (replace 'n' with 'x')
// exention -> exection (replace 'n' with 'c')
// exection -> execution (insert 'u')
 

// Constraints:

// 0 <= word1.length, word2.length <= 500
// word1 and word2 consist of lowercase English letters.

// Runtime 1 ms Beats 68.34%
// Memory 7.42 MB Beats 68.34%
func minDistance(word1 string, word2 string) int {
    distances := make([][]int, len(word1) + 1)
    distances[0] = make([]int, len(word2) + 1)
    for i := 1; i <= len(word2); i++ {
        distances[0][i] = i
    }
    for i := 1; i <= len(word1); i++ {
        distances[i] = make([]int, len(word2) + 1)
        distances[i][0] = i
        for j := 1; j <= len(word2); j++ {
            if word2[j - 1] == word1[i - 1] {
                distances[i][j] = distances[i - 1][j - 1]
            } else {
                distances[i][j] = min(distances[i - 1][j - 1], distances[i][j - 1], distances[i - 1][j]) + 1
            }
        }
    }
    return distances[len(word1)][len(word2)]
}