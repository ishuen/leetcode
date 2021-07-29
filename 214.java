// 214. Shortest Palindrome
// You are given a string s. You can convert s to a palindrome by adding characters in front of it.
//
// Return the shortest palindrome you can find by performing this transformation.
//
// Example 1:
//
// Input: s = "aacecaaa"
// Output: "aaacecaaa"
// Example 2:
//
// Input: s = "abcd"
// Output: "dcbabcd"
//
//
// Constraints:
//
// 0 <= s.length <= 5 * 104
// s consists of lowercase English letters only.
//
// Runtime: 618 ms, faster than 7.98% of Java online submissions for Shortest Palindrome.
// Memory Usage: 38.9 MB, less than 92.46% of Java online submissions for Shortest Palindrome.
class Solution {
    public String shortestPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        int rightBase = right;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                rightBase--;
                right = rightBase;
                left = 0;
            }
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = rightBase + 1; i < s.length(); i++) {
            sb.insert(0, s.charAt(i));
        }
        return sb.toString();
    }
}

// Runtime: 237 ms, faster than 24.18% of Java online submissions for Shortest Palindrome.
// Memory Usage: 40 MB, less than 17.55% of Java online submissions for Shortest Palindrome.
class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i <= sb.length(); i++) {
            if (s.startsWith(sb.substring(i))) {
                return sb.substring(0, i) + s;
            }
        }
        return sb.toString() + s;
    }
}