// 72. Edit Distance
// Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
//
// You have the following 3 operations permitted on a word:
//
// Insert a character
// Delete a character
// Replace a character
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

/**
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
// 88 ms, faster than 80.92%
var minDistance = function(word1, word2) {
  var x = word1.length;
  var y = word2.length;
  if (x == 0 || y == 0) return Math.max(x, y);
  var matrix = [];
  for (var i=0; i < (x+1); i++) {
      matrix[i] = new Array(y+1);
  }
  var ans = 0;
  for (var j = 0; j <= y; j++) {
    matrix[0][j] = j;
  }
  for (var i = 1; i <= x; i++) {
    matrix[i][0] = i;
    for (var j = 1; j <= y; j++) {
      if (word1[i-1] == word2[j-1]) {
        matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j-1], matrix[i-1][j-1] - 1) + 1;
      }
      else {
        matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j-1], matrix[i-1][j-1]) + 1;
      }
      if (i == x && j == y) ans = matrix[i][j];
    }
  }
  return ans;
};