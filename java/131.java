// 131. Palindrome Partitioning
// Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
//
// A palindrome string is a string that reads the same backward as forward.
//
//
//
// Example 1:
//
// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]
// Example 2:
//
// Input: s = "a"
// Output: [["a"]]
//
//
// Constraints:
//
// 1 <= s.length <= 16
// s contains only lowercase English letters.
//
// Runtime: 7 ms, faster than 99.05% of Java online submissions for Palindrome Partitioning.
// Memory Usage: 52.6 MB, less than 76.72% of Java online submissions for Palindrome Partitioning.
class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] matrix = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            matrix[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (matrix[i - 1][j + 1] == true || i - j == 1)) matrix[i][j] = true;
            }
        }
        List<List<String>> ansList = new ArrayList<>();    
        partition(s, 0, matrix, new ArrayList<>(), ansList);
        return ansList;
    }
    private void partition(String s, int start, boolean[][] matrix, List<String> tempList, List<List<String>> ansList) {
        if (start == s.length()) {
            ansList.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (matrix[i][start] == true) {
                tempList.add(s.substring(start, i + 1));
                partition(s, i + 1, matrix, tempList, ansList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

//   a a b a c
// a t
// a t t
// b f f t
// a f t f a
// c f f f f c