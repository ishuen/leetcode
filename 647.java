// 647. Palindromic Substrings
// Given a string s, return the number of palindromic substrings in it.
//
// A string is a palindrome when it reads the same backward as forward.
//
// A substring is a contiguous sequence of characters within the string.
//
//
//
// Example 1:
//
// Input: s = "abc"
// Output: 3
// Explanation: Three palindromic strings: "a", "b", "c".
// Example 2:
//
// Input: s = "aaa"
// Output: 6
// Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
//
//
// Constraints:
//
// 1 <= s.length <= 1000
// s consists of lowercase English letters.
//
// Runtime: 120 ms, faster than 15.21% of Java online submissions for Palindromic Substrings.
// Memory Usage: 37.2 MB, less than 75.35% of Java online submissions for Palindromic Substrings.
class Solution {
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                boolean isPalindrome = true;
                for (int k = 0; k <= j - i; k++) {
                    if (arr[i + k] != arr[j - k]) {
                        isPalindrome = false;
                        break;
                    }
                    if (i + k == j - k || i + k == j - k - 1) break;
                }
                if (isPalindrome == true) count++;
            }
        }
        return count;
    }
}

// Runtime: 6 ms, faster than 58.47% of Java online submissions for Palindromic Substrings.
// Memory Usage: 38.9 MB, less than 45.05% of Java online submissions for Palindromic Substrings.
class Solution {
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        boolean[][] matrix = new boolean[arr.length][arr.length];
        int count = 1;
        matrix[0][0] = true;
        for (int i = 1; i < arr.length; i++) {
            matrix[i][i] = true;
            count++;
            for (int j = 0; j < i; j++) {
                matrix[i][j] = i == j + 1 ? arr[i] == arr[j] : (arr[i] == arr[j] && matrix[i - 1][j + 1] == true);
                if (matrix[i][j] == true) count++;
            }
        }
        return count;
    }
}